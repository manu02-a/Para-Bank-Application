
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
     Given User enters valid username "manubank1" and password "Manubank1"
     When User clicks on login button
     Then User login is successful and user is in account home page
   
   @Login
   Scenario Outline: Verify user able to login with invalid credentials
   	Given User enters username <username> and password <password>
   	When User clicks on login button
   	Then verify user can see the error message as "The username and password could not be verified."
   	And User not in account home page
   	
   	Examples:
   	| username | password |
   	| manubank | Manubank1 |
   	| Manubank1| Manubank |
   	
   	@Login
   	Scenario: Verify user able to login without providing username and password
   		When User clicks on login button
    	Then verify user can see the error message as "Please enter a username and password."
    	And User not in account home page
    	
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
   
   @CountSolutions 	
   Scenario: Verify that the number of Solutions present in the Login Page
		When Count the number of solutions present in the Solutions section
		Then Verify that the total number of solutions is 5

   Scenario: Verify the list of solutions names are present in the application 	
   	When List the solutions names present in the page
   	Then Verify that the listed solutions contains all the below expected solutions
   	| About Us |
   	| Services |
   	| Products |
   	| Locations |
   	| Admin Page |

  
