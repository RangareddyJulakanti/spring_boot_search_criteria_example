# spring_boot_search_criteria_example

POST: http://localhost:8081/search/employee


Body:
-----
{
    "firstName": {
        "operator": "Equals",
        "value": "ranga"
      },
      "lastName": {
        "operator": "NotEquals",
        "value": "reddy"
      },
      "salary": {
        "value": 500000.0,
        "value2": 2000000.0,
        "operator": "Range"
      }
  }
