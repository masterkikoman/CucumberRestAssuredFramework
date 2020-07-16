Feature: Validating Place API's with no dynamic data 

//Scenario: Verify if Place is being successufully added using AddPlaceApi 
	Given add place payload
	When user calls "AddPlaceApi" with Post Http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
	