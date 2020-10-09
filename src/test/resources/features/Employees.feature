Feature: get email from Employees page
  Background:
     Given the user goes to link
     And the user logs in "eventscrmmanager22@info.com" "eventscrmmanager"
  @wip
  Scenario: get email
    And Navigate to Employees page
    And Click the list button
    Then Print the email of David Samson






