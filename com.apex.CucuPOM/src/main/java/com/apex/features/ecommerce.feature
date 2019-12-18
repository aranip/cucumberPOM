Feature: Ecommerce Application Test

Scenario Outline: Validate Ecommerce Login Page Test

Given customer opens browser
Then customer is on login Page
Then customer gives his "<username1>" and "<password1>"
Then customer clicks on signon button
Then validate logged in successfully

Examples: Valid Details
	| username1                | password1 |
	| harikaqa.601@gmail.com   | Welcome@123 |
	|chitraaaaaaa@gmail.com    | chitra121  |