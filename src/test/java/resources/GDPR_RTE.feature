@gdprRTE
Feature: GDPR-Right To Erasure
  
    Scenario: Verify Remove personal data function under contacts menu of UI refresh. The User should be terminated with GDPR RTE reason.
    Given Fetch the data of "TC_001"
    And Login to EC and Create a new User
    And Login in UI Refersh
    When Search the contact and enter the all the details on Remove Personal Data screen and remove the new contact
    Then The user should get terminated with GDPR RTE reason
    And User should logout successfully from UI Refersh

    Scenario: Error message should appear while Removal of Personal Data of a contact which has a live policy
    Given Fetch the data of "TC_002"
    And Login to EC and Create a new policy on the user
    And Login in UI Refersh
    When Search the contact and enter the all the details on Remove Personal Data screen and remove the new contact
    Then Error message should appear while Removal of Personal Data of a contact which has a live or quoted policy
    And User should logout successfully from UI Refersh
    
    
    Scenario: Error message should appear while Removal of Personal Data of a contact which has a Quoted policy
    Given Fetch the data of "TC_003"
    And Login to EC and Create a new Quote on the user
    And Login in UI Refersh
    When Search the contact and enter the all the details on Remove Personal Data screen and remove the new contact
    Then Error message should appear while Removal of Personal Data of a contact which has a live or quoted policy
    And User should logout successfully from UI Refersh

    Scenario: Validation of error messages when URN is missing while Removing Personal Data of user.
    Given Fetch the data of "TC_004"
    And Login to EC and Create a new User
    And Login in UI Refersh
    When Search the contact and Enter all the details other than URN and click on Remove Personal Data button
    Then Error message should appear while Removal of Personal Data of a contact which has a live or quoted policy
    And User should logout successfully from UI Refersh

    Scenario: Validation of error messages when First Name is missing while Removing Personal Data of user.
    Given Fetch the data of "TC_005"
    And Login to EC and Create a new User
    And Login in UI Refersh
    When Search the contact and Enter all the details other than First Name and click on Remove Personal Data button
    Then Error message should appear while Removal of Personal Data of a contact which has a live or quoted policy
    And User should logout successfully from UI Refersh


    Scenario: Validation of error messages when Surname is missing while Removing Personal Data of user.
    Given Fetch the data of "TC_006"
    And Login to EC and Create a new User
    And Login in UI Refersh
    When Search the contact and Enter all the details other than Surname and click on Remove Personal Data button
    Then Error message should appear while Removal of Personal Data of a contact which has a live or quoted policy
    And User should logout successfully from UI Refersh

    Scenario: Validation of error messages when Postal Code is missing while Removing Personal Data of user.
    Given Fetch the data of "TC_007"
    And Login to EC and Create a new User
    And Login in UI Refersh
    When Search the contact and Enter all the details other than Postal Code and click on Remove Personal Data button
    Then Error message should appear while Removal of Personal Data of a contact which has a live or quoted policy
    And User should logout successfully from UI Refersh

    Scenario: Verify customer details on Remove Personal Data screen after removing personal data permenantly.
    Given Fetch the data of "TC_008"
    And Login to EC and Create a new User
    And Login in UI Refersh
    When Search the contact and enter the all the details on Remove Personal Data screen and remove the new contact
    Then Verify that Removal Personal Data screen is refreshed and all the customer detail fields are blank
    And User should logout successfully from UI Refersh

    Scenario: Verify the User status when Remove Personal Data transaction is aborted.
    Given Fetch the data of "TC_009"
    And Login to EC and Create a new User
    And Login in UI Refersh
    When Search the contact and enter the all the details on Remove Personal Data screen and remove the new contact
    Then Verify that user should not get terminated with GDPR RTE reason
    And User should logout successfully from UI Refersh


    Scenario: Verify contact status cannot be changed from Terminated to Active.
    Given Fetch the data of "TC_010"
    And Login to EC and Create a new User
    And Login in UI Refersh
    When Search the contact and enter the all the details on Remove Personal Data screen and remove the new contact
    Then Verify contact status cannot be changed from Terminated to Active
    And User should logout successfully from UI Refersh

   
   
  