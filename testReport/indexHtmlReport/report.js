$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Test-OXYGEN/CucumberAPI_Test/src/test/resources/Features/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Test Cucumber",
  "description": "",
  "id": "test-cucumber",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Demo Login Scenario",
  "description": "",
  "id": "test-cucumber;demo-login-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is already in login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Title of the Login page is Title",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User entered username \"\u003cusername\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User entered password \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User click on the login button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User sucessfully Logged in",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "test-cucumber;demo-login-scenario;",
  "rows": [
    {
      "cells": [
        "username",
        "",
        "password"
      ],
      "line": 13,
      "id": "test-cucumber;demo-login-scenario;;1"
    },
    {
      "cells": [
        "jyotiqa009@gmail.com",
        "",
        "Vicky1234@"
      ],
      "line": 14,
      "id": "test-cucumber;demo-login-scenario;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1134340,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Demo Login Scenario",
  "description": "",
  "id": "test-cucumber;demo-login-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is already in login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Title of the Login page is Title",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User entered username \"jyotiqa009@gmail.com\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User entered password \"Vicky1234@\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User click on the login button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User sucessfully Logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.user_in_already_in_login_page()"
});
formatter.result({
  "duration": 5901057137,
  "status": "passed"
});
formatter.match({
  "location": "loginPage.title_of_the_login_page_is_Title()"
});
formatter.result({
  "duration": 40696,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "jyotiqa009@gmail.com",
      "offset": 23
    }
  ],
  "location": "loginPage.user_entered_Username(String)"
});
formatter.result({
  "duration": 3551185,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Vicky1234@",
      "offset": 23
    }
  ],
  "location": "loginPage.user_entered_Password(String)"
});
formatter.result({
  "duration": 74279,
  "status": "passed"
});
formatter.match({
  "location": "loginPage.user_click_on_the_login_button()"
});
formatter.result({
  "duration": 18175,
  "status": "passed"
});
formatter.match({
  "location": "loginPage.user_sucessfully_Logged_in()"
});
formatter.result({
  "duration": 16989,
  "status": "passed"
});
formatter.after({
  "duration": 138286,
  "status": "passed"
});
});