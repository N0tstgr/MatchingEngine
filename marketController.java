package com.vikash.matchingengine.api;
import com.vikash.matchingengine.model.Order;

import java.util.List;
import com.vikash.matchingengine.engine.OrderBook;
import com.vikash.matchingengine.model.Trade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of("status", "Matching engine is running");
    }

    @GetMapping("/api/book-summary")
    public Map<String, Integer> bookSummary() {
        OrderBook book = marketService.getEngine().getOrderBook();

        return Map.of(
                "bids", book.getBids().size(),
                "asks", book.getAsks().size()
        );
    }
    @GetMapping("/api/book")
    public Map<String, List<Order>> book() {
        OrderBook book = marketService.getEngine().getOrderBook();

        return Map.of(
                "bids", book.getBids(),
                "asks", book.getAsks()
        );
    }
    @PostMapping("/api/orders")
    public List<Trade> placeOrder(@RequestBody OrderRequest request) {
        return marketService.submit(request);
    }
}
