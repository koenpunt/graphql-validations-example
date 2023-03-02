# graphql-validations-example

A sample application to demonstrate an issue with parameters validations with spring-graphql 1.1.2


When you run the playground and perform the following mutation you'll see validation errors in the application log:

```graphql
mutation {
  createCustomerDetails(input:{
    email:"",
    name:"",
    phoneNumber:"",
    locale:"",
    deliveryDetails: null
  }) {
    id
  }
}
```

When you remove the override for the 1.1.1 version from the `build.gradle.kt` file, and rely on 1.1.2 provided through the boot started no validation errors are logged, and the application errors on the `TODO(..)` statement.
