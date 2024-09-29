#@smoke
Feature: F02_LoginForJumia | users could use login functionality to use their accounts
  Background: user going to login page
    When popup open is display user click on newsletter_popup_close
    Given user go to login page by click on login


  Scenario: user could login with valid email and password
    When user enter email "rofida12@example.com" and click to submit btn
    And user login with "rofida12@example.com" and otp_target_display


