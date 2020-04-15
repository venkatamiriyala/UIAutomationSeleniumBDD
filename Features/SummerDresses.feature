Feature: Summer Dresses MegaMenu and Grid Features

 @regression
  Scenario: Verify MegaMenu should work on Summer Dresses page
    Given User launch a browser
    When User Opens URL "http://automationpractice.com/"
    And User Clicks on Dress Mega Menu
    Then Dresses page should load
    When User User Clicks on Summer Dresses Sub Menu
    Then Megamenu should work on Summer DressPage

@regression
  Scenario: Click on Sort By Price on Summer Dress page should arranged product grid properly
  	Given User launch a browser
   	When User Opens URL "http://automationpractice.com/"
   	And User Clicks on Dress Mega Menu
   	Then Dresses page should load
   	When User User Clicks on Summer Dresses Sub Menu
   	And User Clicks on Price: Lowest first Option from the sort by dropdown
   	Then Product grid display products properly with lowest price first
  
 @sanity
   Scenario: Verify Selected Dress with Blue color only added to the Cart
  	Given User launch a browser
   	When User Opens URL "http://automationpractice.com/"
   	And User Clicks on Dress Mega Menu
   	Then Dresses page should load
   	When User User Clicks on Summer Dresses Sub Menu
   	And User Selects a Dress with a Click
   	When Add BLUE color Dress to Cart and Verify Add To Cart 
   	Then Cart Summary Page should display the selected Blue color product only
   	
  