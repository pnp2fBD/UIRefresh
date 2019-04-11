Feature: WJ Smoke Test
@WJSmoke

  Scenario: Login to WJ and Create a 3 start and 5 star policy
    Given User fetches the data of "TC_001"
    And Logs in to WJ
    When User enters the data to create a policy
    Then Policy is created successfully

  Scenario: Create policy in Webjourney - 3Star Monthly
    Given User fetches the data of "TC_002"
    And Logs in to WJ
    When User enters the data to create a policy
    Then Policy is created successfully

  Scenario: Create policy in Webjourney - 5 star Annual
    Given User fetches the data of "TC_003"
    And Logs in to WJ
    When User enters the data to create a policy
    Then Policy is created successfully

  Scenario: Create policy in Webjourney - 5 star Annual
    Given User fetches the data of "TC_004"
    And Logs in to WJ
    When User enters the data to create a policy
    Then Policy is created successfully
