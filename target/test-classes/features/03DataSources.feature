Feature: Data Source CRUD operation 
@Regression 
Scenario Outline: Add Data Source successfully 
	Given I open orbit application website 
	When I sign in username "admin" and password "admin" default credentials 
	Then I navigate to "DataSources" page 
	And I click on new button 
	And I entered the datasource "<row_index>" name 
	Examples: 
		|row_index|
		|0|
		|1|
		|2|
		|3|
		|4|
		|5|
		|6|
		
		