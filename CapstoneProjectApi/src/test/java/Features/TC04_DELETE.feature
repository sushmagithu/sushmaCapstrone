@UserInfoAPI4  @APISuite @Delete


Feature: User_Info_APIDELETE


  Scenario: User Information verification with valid details
    Given I have valid access token and valid URL
    Then I should receive status code as 204

  Scenario Outline: Delete the value of first_name for job 'QA' is ‘Raj’
  
  Given I have valid access token and valid URL for Delete
  Then I should receive status code as 204 for Delete
  And Delete "<first_name>" for the value of "<job>" 
  
  Examples:
   | first_name | job  |
   | Raj      | QA |