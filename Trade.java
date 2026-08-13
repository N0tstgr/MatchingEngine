package com.vikash.matchingengine.model;

public class Trade {
    private final String tradeId;
    private final String buyOrderId;
    private final String sellOrderId;
    private final double price;
    private final int  quantity;
    private final long timestamp;

    public Trade(String tradeId, String buyOrderId, String sellOrderId, double price, int quantity, long timestamp){
        this.tradeId = tradeId;
        this.buyOrderId = buyOrderId;
        this.sellOrderId = sellOrderId;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }
public String getTradeId(){
        return tradeId;
}
public String  getBuyOrderId(){
        return buyOrderId;
}
public String getSellOrderId(){
        return sellOrderId;
}
public double getPrice(){
        return price;
}
public int getQuantity(){
        return quantity;
}
public long getTimestamp(){
        return timestamp;
}
@Override
    public String toString(){
        return String.format("TRADE executed : %d shares @ %.2f (buy=%s, sell=%s)",quantity,price, buyOrderId, sellOrderId);
}

}
