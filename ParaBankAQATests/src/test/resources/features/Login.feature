Feature: Saucelabs Authentication

  Scenario Outline: Logging in with a valid user account
    Given user is on home page
    When logging in with username: <username> and password "Sergiutest1!"
    And submitting login form
    Then user is logged in and redirected to "https://parabank.parasoft.com/parabank/overview.htm"

    Examples:
      | username                  |
      | "Sergiu_Tester"           |

  Scenario Outline: Attempting Login with invalid credentials
    Given user is on home page
    When logging in with username: <username> and password <password>
    And submitting login form
    Then user is not logged in and the message: <errorMessage> is displayed

    Examples:
      | username                      | password                | errorMessage                                                                            |
      | "valid_inexistent"            |     "Sergiutest1!"      |   "An internal error has occurred and has been logged."                                 |
      | "ijvehfveaf"                  |     "Sergiutest1!"      |   "An internal error has occurred and has been logged."                                 |
      | ""                            |     "Sergiutest1!"      |   "Please enter a username and password."                                               |
      | "Sergiu_Tester"               |   ""                    |   "Please enter a username and password."                                               |
