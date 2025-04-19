Feature: Account page service links validation

Background: 
	Given User gets into login page URL

Scenario: Verify that the number of services present in the Account Page
	Given Login to the Application with username "manubank1" and password "Manubank1"
	When Count the number of services present in the Account Services section
	Then Verify that the total number of services is 8
	
Scenario: Verify the service names present in the Account Page
	Given Login to the Application with username "manubank1" and password "Manubank1"
	When Take the Actual service names present in the page
	Then Verify that the Expected service names matches with Actual service names of the page
	| Open New Account |
	| Accounts Overview |
	| Transfer Funds |
	| Bill Pay |
	| Find Transactions |
	| Update Contact Info | 
	| Request Loan |
	| Log Out |