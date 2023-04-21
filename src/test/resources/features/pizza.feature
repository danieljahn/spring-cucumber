Feature: Order Pizza

  Scenario: Order of one pizza
    Given one pizza "Margherita" costs 10 Euro
    When I order 1 pizza "Margherita"
    Then the price is 10 Euro

  Scenario: Order of multiple pizzas
    Given one pizza "Funghi" costs 12 Euro
    When I order 3 pizza "Funghi"
    Then the price is 36 Euro
