package com.vikash.matchingengine.api;

import com.vikash.matchingengine.model.OrderSide;
import com.vikash.matchingengine.model.OrderType;

public record OrderRequest(
        String symbol,
        OrderSide side,
        OrderType type,
        double price,
        int quantity
) {
}
