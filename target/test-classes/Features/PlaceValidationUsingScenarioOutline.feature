Feature: Validating Place API's with Dynamic Data


@AddPlace @Regression
Scenario Outline: Verify if Place is being successufully added using AddPlaceApi 
	Given add place payload with "<name>" "<language>" "<address>"
	When user calls "addPlaceAPI" with "Post" Http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name         | language | address          |
	|Sm Light Mall| Tagalog  | Boni Mandaluyong |
	#|Sm Mega Mall | Taglish  | Mandaluyong/Pasig|
	
@DeletePlace @Regression
Scenario: Verify if Delete Place Functionality is working
	Given DeletePlace Payload 
	When user calls "deletePlaceAPI" with "Post" Http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"