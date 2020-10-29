Feature: Post Genres End point
  Background:
    Given the user set uri

  Scenario: Post

    And the user sends post request "/genres" with end point
    When Verify the status code is 201
    And Verify the content type is "application/json; charset=utf-8"


    Scenario: Get

      And the user sends get request with "/genres" endpoint
      When Verify the status code is 200
      And Verify the content type is "application/json; charset=utf-8"

      Scenario: Get with queryParam

        And the user sends get request with "/genres" endpoint and 737 qyery
        When Verify the status code is 200
        And Verify the content type is "application/json; charset=utf-8"


       Scenario: Put
         When the user sends put request with "/genres" endpoint
         When Verify the status code is 204


         Scenario: delete
           When the user sends delete request with "/genres" endpoint 735 pathParam
           When Verify the status code is 204


