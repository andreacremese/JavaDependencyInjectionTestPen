package com.mono.testing.m6;

import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

// Business logic layer
public class SalesAnalyser {
    private final SalesRepository repo;

    public SalesAnalyser(SalesRepository repo) {
        this.repo = repo;
    }

    public Map<String, Integer> TallyCitySales() {
        return repo.loadSales()
                .stream()
                .collect(
                        groupingBy(Sale::getStore, summingInt(Sale::getValue)));

    }
}
