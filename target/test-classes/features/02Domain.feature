Feature: User management , Domain Creation and Report validation 

@Regression 
Scenario: Verify private and public links 

	Given I open orbit application website 
	When I sign in username "admin" and password "admin" default credentials 
	And  I navigate to "Reports" page 
	Then I choose Generate Link option from menu list 
	And I Generate report links 
	And I sign out 	
	And I navigated to "Private" link and Run report 
	When I login to application username "admin" and password "admin" no validation 
	And I Run the report	
	And I navigated to "public" link and Run report 
	And I Run the report