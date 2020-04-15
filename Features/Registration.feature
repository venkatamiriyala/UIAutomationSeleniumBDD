Feature: User Email Registration

  @regression
  Scenario: User should Able to register in the site with a valid Email ID
    Given 	User launch a browser
    When User Opens URL "http://automationpractice.com/"
    And  User Click on Sign in link
    Then Page Header should be AUTHENTICATION page
    When User Enters Email as "Ven1126@ven.com" and Submits
    Then Create an Account page should displayed
    Given Enter User Details and Register
    Then User Email Registration must be Successful
  @regression
  Scenario: System should NOT allow users to register with An INVALID Email ID
    Given 	User launch a browser
    When User Opens URL "http://automationpractice.com/"
    And  User Click on Sign in link
    Then Page Header should be AUTHENTICATION page
    When User Enters Email as "Ven1121@ven" and Submits
    Then User should get an Invalid Email ID Error Message
