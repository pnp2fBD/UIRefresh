@uirefreshSmoke 
Feature: UIRefresh Contacts Test cases 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_000" 
	And Login in UI Refresh
	When Search existing contact in Contact Search  
	And Update the contact  
	And User should logout successfully from UI Refresh 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_015" 
	And Login in UI Refresh 
	And Create a new contact in UI Refresh
	And User should logout successfully from UI Refresh  