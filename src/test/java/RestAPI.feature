Feature: Calculator REST API
	Scenario: Invoking addition
		Given Rest Api "http://localhost:9400/addition?firstOperand=10.0&secondOperand=10.0"
		When I invoke the given rest api
		Then the expected sum is 20.0
		

