Feature: Search for available flight

  Search in ryanair for available one way or round-trip flight.

  Scenario Outline: Search for flight in ryanair
    Given That I have enter to Ryanair page
    When I search for a "<type>" flight
    And from "<origin>" to "<destination>"
    And with dates: "<dateOut>" and "<dateBack>"
    Then I should get <num> rows

    Examples:
      | origin        | destination | type   | dateOut       | dateBack      | num |
      | Madrid        | Barcelona   | oneway | June 19, 2020 | 0             | 2   |
      | Fuerteventura | Seville     | return | June 19, 2010 | June 25, 2020 | 1   |
