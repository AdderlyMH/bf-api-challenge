Feature: Add new pet API testing

  Scenario Outline: Create a new pet
    Given a payload with parameters <id> <cat_id> "<cat_name>" "<name>" "<photoUrls>" <tags_id> "<tags_name>" "<status>"
    When user sends a "POST" request from the API PET v2
    Then the response status code is 200
    And the "status" field value is "<status>"
    Examples:
      | id | cat_id | cat_name | name   | photoUrls      | tags_id | tags_name | status      |
      | 8  | 7      | string   | robert | string         | 12      | string    | available   |
      | 75 | 23     | string2  | luis   | string32, url3 | 4       | string4   | unavailable |

  Scenario: Create new pet with json file
    Given a payload file named "addPet"
    When user sends a "POST" request from the API PET v2
    Then the response status code is 200
    And the "status" field value is "available"