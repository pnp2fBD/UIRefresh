@uirefreshSmoke 
Feature: UIRefresh Household 2 Smoke Test cases 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_021" 
	And Login to EC and Create a new User 
	And Login in UI Refresh 
	When Search the existing contact 
	Then Create NB in UI Refresh 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_022" 
	And Login in UI Refresh 
	And Create a new contact in UI Refresh 
	Then Create NB in UI Refresh 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_023" 
	And Login in UI Refresh 
	And Create a new contact in UI Refresh 
	Then Create NB in UI Refresh 
	And Cancel the Policy with Cooling Off 
	And User should logout successfully from UI Refresh 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_024" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Cancel the Policy 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_025" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Invite Renewal for the Policy 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_026" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Endorse the Policy with min cover 
	And User should logout successfully from UI Refresh 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_027" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Perform STA with min cover 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_028" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Perform Adjust Billing 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_029" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create Quote in UI Refresh 
	And Lapse an existing Quote 
	And User should logout successfully from UI Refresh
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_030" 
	And Login to EC and Create a new User 
	And Login in UI Refresh 
	When Search the existing contact 
	Then Create NB with Joint PolicyHolder 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_031" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Cancel the Policy with Cooling Off 
	And Reinstate the Cancelled Policy 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_032" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Endorse the Policy with min cover 
	And Perform Reverse Transaction 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_033" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create Quote with prior claim 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_034" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create Quote with prior claim
	And Generate ARN Code
	And Accept the policy with referrals reason 
	And User should logout successfully from UI Refresh 
	
	
	
	