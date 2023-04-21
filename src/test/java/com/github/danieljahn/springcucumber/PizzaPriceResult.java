package com.github.danieljahn.springcucumber;

import org.springframework.stereotype.Component;

@Component
public class PizzaPriceResult {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
