package com.vikash.matchingengine.model;

import java.util.ArrayList;
import java.util.List;

public class MatchingEngine {
import com.vikash.matchingengine.model.Order;
import com.vikash.matchingengine.model.OrderSide;
import com.vikash.matchingengine.model.OrderType;
import com.vikash.matchingengine.model.Trade;

import java.util.ArrayList;
import java.util.List;
public class MatchingEngine{
    private final OrderBook orderBook = new OrderBook();
    private int tradeCounter = 0;
    public List<Trade>submitOrder(Order incoming){
        List<Trade> trades = new ArrayList<>();
        if(incoming.getSide()==OrderSide.BUY){
            matchBuyOrder(incoming, trades);
        }else{
            matchSellOrder(incoming, trades);
        }
        if(incoming.getQuantity()> 0 && incoming.getType() == OrderType.LIMIT){
            OrderBook.addOrder(incoming);
        }
        return trades;
    }
    private void matchBuyOrder(Order buyOrder, List<Trade> trades){
        while(buyOrder.getQuantity() > 0){
            Order bestAsk = orderBook.getBestAsk();
            if(bestAsk==null) break;

            boolean priceCrosses = buyOrder.getType()==OrderType.MARKET || buyOrder.getPrice() >= bestAsk.getPrice();
            if(!priceCrosses) break;
            int tradeQty = Math.min(buyOrder.getQuantity(), bestAsk.getQuantity());
            double tradePrice = bestAsk.getPrice();
            trades.add(createTrade(buyOrder.getOrderId(), bestAsk.getOrderId(), tradePrice, tradeQty));
            buyOrder.setQuantity(buyOrder.getQuantity() - tradedQty);
            bestAsk.setQuantity(bestAsk.getQuantity() - tradedQty);
            if(bestAsk.getQuantity() == 0){
                orderBook.removeOrder(bestAsk);
            }
        }
    }

    private void matchSellOrder(Order sellOrder, List<Trade> trades){
        while(sellOrder.getQuantity() > 0){
            Order bestBid = orderBook.getBestBid();
            if(bestBid = null) break;

            boolean priceCrosses = sellorder.getType() == OrderType.MARKET
                    || sellOrder.getPrice() <=bestBid.getprice();
            if(!priceCrosses) break;

            int tradeQty = Math.min(sellOrder.getQuantity(), bestBid.getQuantity());
            double tradePrice = bestBid.getprice();

            trades.add(createTrade(bestBid.getOrderId(), sellOrder.getOrderId(), tradePrice, tradeQty));
            sellOrder.setQuantity(sellOrder.getQuantity() - tradeQty);
            bestBid.setQuantity(bestBid.getQuantity() - tradeQty);

            if(bestBid.getQuantity()==0){
                orderBook.removeOrder(bestBid);
            }
        }
    }
    private Trade createTrade(String buyOrder-)
}
}














