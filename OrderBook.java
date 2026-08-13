package com.vikash.matchingengine.model;
import com.vikash.matchingengine.model.Order;
import com.vikash.matchingengine.model.OrderSide;

import java.util.ArrayList;
import java.util.List;
public class Orderbook {
    private final List<Order> bids = new ArrayList<>(); //BUY Orders
    private final List<Order> asks = new ArrayList<>(); //sell orders


    public void addOrder(Order order){
        if(order.getside()==OrderSide.BUY){
            bids.add(order);
            bids.sort((a,b)->{
                int priceCompare = Double.compare(b.getprice(), a.getprice());
                if(priceCompare !=0)return priceCompare;
                return Long.compare(a.gettimestamp(), b.gettimestamp());
            });
        }else{
            asks.add(order);
            asks.sort((a,b)->{
                int priceCompare = Double.compare(a.getprice(), b.getprice());
                if(priceCompare !=0) return priceCompare;
                return Long.compare(a.gettimestamp(), b.gettimestamp());
            });
        }
    }
    public void removeOrder(Order order){
        if(order.getside()==OrderSide.BUY){
            bids.remove(order);
        }else{
            asks.remove(order);
        }
    }
    public boolean cancelOrder(String orderId){
        return bids.removeIf(o->o.getOrderId().equals(orderId))||
                asks.removeIf(o->o.getOrderId().equals(orderId));
    }
    public Order getBestBid(){
        return bids.isEmpty()? null : bids.get(0);
    }
    public Order getBestAsk(){
        return asks.isEmpty() ? null : asks.get(0);
    }
    public List<Order> getBids(){
        return bids;
    }
    public List<Order> getAsks(){
        return asks;
    }
    public void printBook(){
        System.out.println("-----Order BOOK -----");
        System.out.println("Asks (Sell side, lowest price first ) ");
        for(int i = asks.size() - 1; i>=0; i--){
            System.out.println("   " + asks.get(i));
        }
        System.out.println("BIDS ( buy side, highest price first)");
        for(Order b : bids){
            System.out.println("  " + b);
        }
        System.out.println("----------------------------");
    }
    

}










