Feature: Login Page Aplikasi Kasir Aja

  @Regression @Positive
  Scenario: Success Login
    Given Halaman login kasir aja
    When Input username
    And Input password
    And click login button
    Then User in on dashboard page

  @Regression @Negative
  Scenario: Failed Login
    Given Halaman login kasir aja
    When Input username
    And Input Invalid password
    And click login button
    Then User get error message

  @DDT
  Scenario Outline: Login to kasir Aja
    Given Halaman login kasir aja
    When I input <email> as email
    And I input <password> as password
    And click login button
    Then I verify <status> login result

    Examples:
      | email                | password      | status |
      | toko@untungterus.com | Untungterus77 | sucess |
      | toko@rugiterus.com   | failed-login  | failed |

