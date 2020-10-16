Feature: Movies end point
  Scenario: get request
    Given the user set uri
    And the user sends get request with "/movies" end point 1459
    When Verify the status code is 200
    And Verify the content type is "application/json; charset=utf-8"
    Then Verify the response body is equal which is you posted

