
Feature: Login page functionalities and validation

Background: 
	Given User gets into login page URL
	
	@Register
	Scenario: Verify user able to register using register link
		Given user clicks on register link
		When user enters all the fields in the page
		| Manu |
		| A |
		| Bangaluru |
		| Bangaluru |
		| Karnataka |
		| 560056 |
		| 9876543 |
		| 12 |
		| manubank1 |
		| Manubank1 |
		| Manubank1 |
		Then user gets successful message "Your account was created successfully. You are now logged in."
  
  @Login
  Scenario: Verify user able to login to application with valid credentials
    Given User enters username "manubank1" and password "Manubank1"
    When User clicks on login button
    Then User login is successful and user is in account home page
    
    @ForgotInfo
    Scenario: Verify user able to retrive the credentials usering forgot info link
    	Given user clicks on Forgot login Info link
    	When user enters all the fields in the page Forgot Info Page
    	| Manu |
    	| A |
    	| Bangaluru |
    	| Bangaluru |
    	| Karnataka |
    	| 560056 |
    	| 12 | 
    	And user clicks on Find My Login Info button
    	Then user gets successful message as "Your login information was located successfully. You are now logged in."
    	And user gets username and password
    	

    	

  
