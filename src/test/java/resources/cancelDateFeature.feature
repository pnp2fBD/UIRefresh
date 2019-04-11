Feature: 891-Cancel Date Feature
@cancelDate
Scenario: Validate the Cancellation Date after performing Cooling off cancellation on a policy
    Given User fetches the data of "TC_001"
    And Login to EC
    And Create a  new policy
    When Cancel the policy using Cooling off option
    Then Cancel Date should appear in correct format on Dashboard after cancelling the policy
    And  User should logout successfully


Scenario: Validate the Cancellation Date after performing Standard Cancellation on a policy
    Given User fetches the data of "TC_002"
    And Login to EC
    And Create a new policy
    When Cancel the policy using Standard Cancellation option
    Then Cancel Date should appear in correct format on Dashboard after cancelling the policy
    And  User should logout successfully
    
Scenario: Validate the Policy Status after Reinstating the cancelled policy
    Given User fetches the data of "TC_003"
    And Login to EC
    And Create a new policy
    When Cancel the policy using Standard Cancellation option
    Then Cancel Date should appear in correct format on Dashboard after cancelling the policy
    And  Reinstate the policy and validate the status is Active
    And  User should logout successfully
    

