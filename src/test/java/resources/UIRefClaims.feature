@uirefreshSmoke
Feature: UIRefresh Claims Test cases 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_040" 
	And Login in UI Refresh 
	And Create a new contact in UI Refresh
	Then Create NB in UI Refresh 
	And Create Notified claim for policy
	And User should logout successfully from UI Refresh 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_041" 
	And Login in UI Refresh 
	And Create a new contact in UI Refresh
	Then Create NB in UI Refresh 
	And Create open claim
	And User should logout successfully from UI Refresh	
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_042" 
	And Login in UI Refresh 
	And Create a new contact in UI Refresh
	Then Create NB in UI Refresh 
	And Create claim and finalised it in close status
	And User should logout successfully from UI Refresh		

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_043" 
	And Login in UI Refresh 
	And Create a new contact in UI Refresh
	Then Create NB in UI Refresh
	And Create open claim 
	And Create receipt
	And Edit claim and reconcile allocate recovery receipt
	And User should logout successfully from UI Refresh	