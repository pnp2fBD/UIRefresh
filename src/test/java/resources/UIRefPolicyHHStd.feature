@uirefreshSmoke 
Feature: UIRefresh Policy Household Standard Test cases 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_000" 
	And Login in UI Refresh
	When Search existing contact in Contact Search  
	And Update the contact  
	And User should logout successfully from UI Refresh 

Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_001" 
	And Login to EC and Create a new User 
	And Login in UI Refresh 
	When Search the existing contact 
	Then Create NB in UI Refresh 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_002" 
	And Login in UI Refresh 
	And Create a new contact in UI Refresh  
	Then Create NB in UI Refresh 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_003" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Cancel the Policy with Cooling Off 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_004" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Cancel the Policy 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_005" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Invite Renewal for the Policy 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_006" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Endorse the Policy with min cover 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_007" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Perform STA with min cover 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_008" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Perform Adjust Billing 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_009" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create Quote in UI Refresh 
	And Lapse an existing Quote 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_010" 
	And Login to EC and Create a new User 
	And Login in UI Refresh 
	When Search the existing contact 
	Then Create NB with Joint PolicyHolder 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_011" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Cancel the Policy with Cooling Off 
	And Reinstate the Cancelled Policy 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_012" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create NB in UI Refresh 
	And Endorse the Policy with min cover 
	And Perform Reverse Transaction 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_013" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create Quote with prior claim 
	And User should logout successfully from UI Refresh 
	
Scenario: Create basic policy in UIRefesh for an existing contact. 
	Given Fetch the UIRef data of "TC_014" 
	And Login in UI Refresh 
	When Search the existing contact Jason Smith 
	Then Create Quote with prior claim
	And Generate ARN Code
	And Accept the policy with referrals reason 
	And User should logout successfully from UI Refresh 
