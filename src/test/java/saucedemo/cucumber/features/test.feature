Feature: Sauce Demo

  @All @Login_Success
  Scenario: Login Sukses
    Given Halaman Login
    When Input Username
    And Input Password
    And Click Login Button
    Then User in on first page

  @All @Login_Failed
  Scenario: Login gagal
    Given Halaman Login
    When Input Username
    And Input Invalid Password
    And Click Login Button
    Then User get error message

  @All @AddToCart
  Scenario: Menambahkan Product yang ingin dibeli
    Given Halaman Login
    When Input Username
    And Input Password
    And Click Login Button
    And First page after login success
    Then Choice Product

  @All @RemoveCart
  Scenario: Menghapus Product yang sudah dipilih
    Given Halaman Login
    When Input Username
    And Input Password
    And Click Login Button
    And First page after login success
    And Pilih Product
    Then Choice Remove

  @All @Checkout
  Scenario: Checkout Product
    Given Halaman Login
    When Input Username
    And Input Password
    And Click Login Button
    And First page after login success
    And Pilih Product
    And Click Gambar Troli
    And Click Checkout
    And Input Firstname
    And Input Lastname
    And Input Postal Code
    And Click Continue
    Then Checking and Finish