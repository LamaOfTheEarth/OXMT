# Technical task for OXMT

This microservice was made using spring boot, java and SMILE.

Click below to run microservice when opened inside intellij

`MachineAgeValidatorApplication`

## Example Requests

```Json
[
    {"machineID": "1", "age": "2 years"},
    {"machineID": "2", "age": "6 months"},
    {"machineID": "3", "age": "30 days"},
    {"machineID": "4", "age": "90 years"},
    {"machineID": "5", "age": "1 year"},
    {"machineID": "6", "age": "16 months"}
]
```

#### Expected Result
```Json
[
    {
        "machineID": "4",
        "age": "90 years"
    }
]
```
#### Example 2
```Json
[
  {"machineID": "7", "age": "3 years"},
  {"machineID": "8", "age": "8 months"},
  {"machineID": "9", "age": "15 days"},
  {"machineID": "10", "age": "120 years"},
  {"machineID": "11", "age": "2 years"},
  {"machineID": "12", "age": "9 months"},
  {"machineID": "13", "age": "1 month"},
  {"machineID": "14", "age": "80 years"},
  {"machineID": "15", "age": "3 years"},
  {"machineID": "16", "age": "10 months"}
]
```

#### Expected Result
```Json
[
  {
    "machineID": "10",
    "age": "120 years"
  },
  {
    "machineID": "14",
    "age": "80 years"
  }
]
```

## Further improvement for production

+ Unit testing using either junit or mockito framework
+ Error handling 
+ Logging 
+ Request validation
+ Security
+ Optimise for larger data sets
+ Documentation
+ Containerisation using docker
+ Setting up a pipeline for automated builds and deployments