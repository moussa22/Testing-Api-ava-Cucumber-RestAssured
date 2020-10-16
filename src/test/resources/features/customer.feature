Feature: Customer testing

  Scenario Outline: Boarding new customer
    Given I have the data to create customer with "<firstName>", "<lastName>",  "<phone>", "<address1>", "<address2>"
    And I use the customer header
    When I create post request to create customer
    Then I get status code 201 from database
    And response body should contain

      | firstName |
      | lastName  |
      | phone     |
      | addresses |
      | id        |

    Examples:
      | firstName  | lastName | phone  |  address1 | address2 |
      | Alex       | Kozlov   | 123    |  Backer2  | Union3   |

  Scenario: Get new Customer
    Given I use the customer header
    When I create get request to get new  customer
    Then I get status code 200 from database

Scenario: Delete new Customer
  Given I use the customer header
  When I create delete request to delete new  customer
  Then I get status code 200 from database

