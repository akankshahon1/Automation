Feature: Validating place API's
@AddPlace @Regression
  Scenario Outline: Verify if place is being successfully added using AddPaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"
    Examples:
      | name   | language | address       |
      | Ahouse | English  | Solarium city |
    #  | Bhouse |Spanish   |Krishna PG     |

@DeletePlace @Regression
  Scenario: Verify if Delete place functionality is working
    Given DeletePlace payload
    When User calls "deletePlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"