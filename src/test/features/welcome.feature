Feature: the client call welcome page
  Scenario: client makes call to GET /welcome
    When the client calls /welcome
    Then the client receives status code of 200
    And the client receives Hello World!
