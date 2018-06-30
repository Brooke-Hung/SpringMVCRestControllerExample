# SpringMVCRestControllerExample
Demonstrates use of creating REST APIs using @RestController. In the project, the following base controllers are provided to facilitate API development:

- BaseRestController provides CRUD operations.

- BaseDetailsRestController provides CRUD operations and disables search. This is for details.

- BaseReadOnlyRestController provides getById and search operations. This is for read only info.

## Response formats:

- JSON
- XML

## How to test?

```
mvn clean test
```