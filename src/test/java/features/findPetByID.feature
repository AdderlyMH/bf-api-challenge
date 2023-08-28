Feature: Find pet by ID API testing

  @FindPet
  Scenario: Find a pet
    Given a previously created pet
    When user sends a "GET" request from the API PET v2
    Then the response status code is 200
    And the "status" field value is "available"