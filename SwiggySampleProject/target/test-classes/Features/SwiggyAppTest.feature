Feature: Test Swiggy application
@RegressionTest
Scenario Outline:To navigate to home location
Given user is in Swiggy application
When user seaches "<location>" in the page
Then user navigates to homepage
Examples:
|location|
|Vanchiyoor|

@RegressionTest
Scenario: To login to swiggy app
Given user is in application
And user clicks on Login button
When user enters "<phonenumber>"
Then user should click on login
And verify the navigation
