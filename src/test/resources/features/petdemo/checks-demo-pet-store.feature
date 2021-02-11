Feature: Test Pet Demo API
  Scenario Outline: Test that API is working correctly
    Given The following API : "<url>", Test GET, POST, UPDATE and DELETE
    When The client request "<status1>" pets
    Then The client checks that all pets are "<status1>"
    When The client adds a new pet
    Then The client check that the pet is added
    When The client update pet with status "<status2>"
    Then The client check that status has changed to "<status2>"
    When The client delete this pet from the store
    Then The client check if the pet has been removed from the store

    Examples:
      | url                          | status1   | status2 |
      | https://petstore.swagger.io  | available | sold    |