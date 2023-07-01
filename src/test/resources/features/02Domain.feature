Feature: User management , Domain Creation and Report validation 
Scenario: Verify Domain has been created successful 
	Given I open orbit application website 
	When  I login with newly created credentials 
	Then I navigate to "Domains" page 
	And I created New Domain name 
	And I created New Physical model with "iorb4" data source name 
	And I Selected Objects "EMP" and "DEPT" from relational database "SCOTT" to be included in the physical model 
	And I created new Logical Model 
	And I give relationship between "EMP" and "DEPT" tables 
	And I created new Business Object 
	And I built the business object layer 
	And I built New Category and moved data columns for chosen business objects 
	Then I navigate to "Reports" page 
	And I clicked on New Report Button and choose the "Data Report" from Menu List 
	And I open Business Object Window enter the Object name in textfield 
	And I drag and drop attributes and ran the report 
	And I Save report in folder 
	
@Regression 
Scenario: Verify data report export to excel successful 

	Given I open orbit application website 
	When I sign in username "admin" and password "admin" default credentials 
	And  I navigate to "Reports" page 
	Then I choose edit option from menu list and Run and Save report 
	And I export the report in excel format 
