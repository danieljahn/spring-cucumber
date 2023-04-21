package com.github.danieljahn.springcucumber;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PizzaRepo {

    private final Map<String, Integer> prices = new HashMap<>();

    public int getPrice(String pizzaType) {
        return prices.get(pizzaType);
    }

    public void setPrice(String pizzaType, int price) {
        prices.put(pizzaType, price);
    }
}
