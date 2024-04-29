Feature: Student registration form

Scenario Outline: Verify that student registired data is stored properly or not.
Given student is in the registration form
When student enter all the data to text field
And student should click on the Submit button
Then student should be get the register details window 
