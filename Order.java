package com.vikash.matchingengine.model;

public class Order {
    private final String orderId;
    private final String symbol;
    private final OrderSide side;
    private final OrderType type;
    private final double price;
    private int quantity;
    private final long timestamp;

    public Order(String orderId, String symbol, OrderSide side, OrderType type,
                 double price, int quantity, long timestamp) {
        this.orderId = orderId;
        this.symbol = symbol;
        this.side = side;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getsymbol() {
        return symbol;
    }

    public OrderSide getside() {
        return side;
    }

    public OrderType gettype() {
        return type;
    }

    public double getprice() {
        return price;
    }

    public  int getQuantity() {
        return quantity;
    }

    public  void setQuantity(int Quantity) {this.quantity = quantity;}

    public long gettimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("{orderId { id=%s, %s, %s, qty=%d, price=%.2f}",
                orderId, side, type, quantity, price);
    }
}
