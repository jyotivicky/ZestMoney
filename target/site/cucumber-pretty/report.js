$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("feature/locusTest.feature");
formatter.feature({
  "line": 1,
  "name": "Locus Test Project",
  "description": "",
  "id": "locus-test-project",
  "keyword": "Feature"
});
formatter.before({
  "duration": 25198491500,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "User Opened Flipkart And Search For Shoes",
  "description": "",
  "id": "locus-test-project;user-opened-flipkart-and-search-for-shoes",
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
  "line": 4,
  "name": "flipkart Website opened sucessfully",
  "keyword": "Given "
});
formatter.match({
  "location": "LocusTest.searchForShoes()"
});
formatter.result({
  "duration": 1328127400,
  "status": "passed"
});
formatter.after({
  "duration": 117500,
  "status": "passed"
});
formatter.after({
  "duration": 53800,
  "status": "passed"
});
});