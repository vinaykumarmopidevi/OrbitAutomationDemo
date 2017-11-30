Feature: User management 
@Regression
Scenario: Verify user account has been created successful 
	Given I open orbit application website 
	When I sign in username "admin" and password "admin" default credentials 
	Then I navigate to "Users" page 
	And I click on new user button 
	And I enter "NewUser" user name 
	And I enter first name 
	And I enter last name 
	And I enter email "automationorbit@gmail.com" address 
	And I click on save "onSaveBtn" button 	
	Then I navigate to "Roles" page 
	And I assigned "Admin" role to new user 
	Then I navigate to "Users" page
	And I click on search icon 
	And I search "NewUser" user name 
	And I moved to lock icon and double click on icon 
	And I click on Yes button on Status Change popup 
	And I sign out 
	And I Activated new user and captured system generated password using email "automationorbit@gmail.com" and password "Orbit@123" configaration 
	And I sign with custom credentials 
	And I change password 
	And I sign out 
	And I sign in with custom credentials 
	And I sign out 
