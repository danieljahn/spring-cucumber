package com.github.danieljahn.springcucumber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

    private final PizzaService service;

    public PizzaController(PizzaService service) {
        this.service = service;
    }

    @GetMapping("/pizza")
    public int order(@RequestParam String type, @RequestParam int quantity) {
        return service.getPrice(type, quantity);
    }
}
