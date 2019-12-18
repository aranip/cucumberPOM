Feature: Ecommerce Application Test

Scenario Outline: Validate Ecommerce Login Page Test

Given The person enters chrome browser
Then person will be in login Page
Then person gives his <Username> and <Password>
Then person clicks on signon button
Then validating logged in successfully or not

Examples: 
	| Username               | Password |
	| harikaqa.601@gmail.com   | Welcome@123 |
	|chitraaaaaaa@gmail.com    | chitra121  |