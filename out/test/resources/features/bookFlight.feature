Feature: Search for available flight

  Search in ryanair for available one way or round-trip flight.

  Scenario Outline: Search for flight in ryanair
    Given That I have enter to Ryanair page
    When I search for a available flight from "<origin>" to "<destination>"
    And is "<type>"
    And with dates: "<date>" and "<dateReturn>"
    Then I should get <num> rows

    Examples:
      | origin    | destination | type   | date          | dateReturn    | num |
      | Madrid    | Barcelona   | oneway | June 19, 2020 | June 25, 2020 | 2   |
      | Barcelona | Madrid      | return | June 19, 2010 | 0             | 1   |
