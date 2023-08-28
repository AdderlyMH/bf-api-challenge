Feature: Update pet API testing

  @UpdatePet
  Scenario: Find a pet
    Given a string payload
    When user sends a "PUT" request from the API PET v2
    Then the response status code is 200
    And the "status" field value is "available"