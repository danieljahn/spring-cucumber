package com.github.danieljahn.springcucumber;

import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    private final PizzaRepo repo;

    public PizzaService(PizzaRepo repo) {
        this.repo = repo;
    }

    public int getPrice(String pizzaType, int quantity) {
        return quantity * repo.getPrice(pizzaType.toLowerCase());
    }
}
