Feature: Post Genres End point
  Scenario: Post
    Given the user set uri
    And the user sends request "/genres" with end point
    When Verify the status code is 201
    And Verify the content type is "application/json; charset=utf-8"