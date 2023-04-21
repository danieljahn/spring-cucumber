package com.github.danieljahn.springcucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class PizzaSteps {

    @Autowired
    PizzaRepo repo;

    @Autowired
    WebTestClient client;

    @Autowired
    PizzaPriceResult pizzaPriceResult;

    @Given("one pizza {string} costs {int} Euro")
    public void onePizzaCostsEuro(String pizzaType, int price) {
        repo.setPrice(pizzaType.toLowerCase(), price);
    }

    @When("I order {int} pizza {string}")
    public void iOrderPizza(int quantity, String pizzaType) {
        final var result = client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/pizza")
                        .queryParam("quantity", quantity)
                        .queryParam("type", pizzaType)
                        .build())
                .exchange()
                .returnResult(int.class);

        final var pizzaPrice = result.getResponseBody().blockFirst();
        pizzaPriceResult.setPrice(pizzaPrice);
    }

    @Then("the price is {int} Euro")
    public void thePriceIsEuro(int price) {
        Assertions.assertThat(pizzaPriceResult.getPrice()).isEqualTo(price);
    }
}
