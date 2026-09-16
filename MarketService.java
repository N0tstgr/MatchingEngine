package com.vikash.matchingengine.api;

import com.vikash.matchingengine.engine.MatchingEngine;
import com.vikash.matchingengine.model.Order;
import com.vikash.matchingengine.model.Trade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MarketService {

    private final MatchingEngine engine = new MatchingEngine();
    private final AtomicLong orderSequence = new AtomicLong();

    public MatchingEngine getEngine() {
        return engine;
    }

    public List<Trade> submit(OrderRequest request) {
        String orderId = "O" + orderSequence.incrementAndGet();

        Order order = new Order(
                orderId,
                request.symbol(),
                request.side(),
                request.type(),
                request.price(),
                request.quantity(),
                System.nanoTime()
        );

        return engine.submitOrder(order);
    }
}
