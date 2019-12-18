Feature: ecommerce Registration Feature
Scenario Outline: ecommerce Registration Test Scenario

Given user opens the browser
When user is on login page
Then user clicks on signUp button
Then user checks Gender button
Then user enters Contact info "<firstName>" and "<lastName>" and "<dateofBirth>"and"<month1>"and "<year1>" and "<mail>"and "<homeNumber>"and"<add>" and "<cityy>"and"<stat>"and "<postal>"and"<phoneNo>"and"<"faxno>"and"<PWD>"and"<"Cpwd>"
Then user clicks on terms
Then user clicks submit button
Then validate if user signedUP successfully
Then close the browser

Examples:
| firstName| lastName | dateofBirth | month1| year1 | mail                 | homeNumber| add    | cityy   | stat   | postal|phoneNo       | faxno       |PWD               |Cpwd|
| Ankitha   | rao     | 02          | 03 |1999 |ankithrao1123@gmail.com| 19-23     | walnut | fremont | usa    |84754  |8884443567|737456 | ankitha123           |ankitha123|
| Manisha   |singh    |04           |09  |1978 |manisha3121@gmail.com  | 8485      |paseo   |sunnyval |usa     |77744  |8934189898|998278 |manisha123            |manisha123|