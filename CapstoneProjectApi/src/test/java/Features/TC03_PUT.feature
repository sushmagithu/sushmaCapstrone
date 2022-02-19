@UserInfoAPI3  @APISuite @Put


Feature: User_Info_APIPUT


  Scenario: User Information verification with valid details
    Given I have valid access token and valid URL
    Then I should receive status code as 200

  Scenario Outline: Verify the value of first_name for id 10 is ‘Byron’
  
  Given I have valid access token and valid URL for Put
  Then I should receive status code as 200 for Put
  And update "<first_name>" for the value of "<job>" 
  
  Examples:
   | first_name | job  |
   | Raj      | QA |

  