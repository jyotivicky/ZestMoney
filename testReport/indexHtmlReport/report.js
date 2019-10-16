$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Selenium_Project/API_Automation/feature/docker.feature");
formatter.feature({
  "line": 1,
  "name": "My Cucumber Test",
  "description": "",
  "id": "my-cucumber-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 15082369000,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Checking Cucumber",
  "description": "",
  "id": "my-cucumber-test;checking-cucumber",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Webpage opened sucessfully",
  "keyword": "Given "
});
formatter.match({
  "location": "DockerDemoTest.openAndClick()"
});
formatter.result({
  "duration": 260886500,
  "status": "passed"
});
formatter.after({
  "duration": 134700,
  "status": "passed"
});
formatter.after({
  "duration": 33800,
  "status": "passed"
});
});