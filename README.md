# BankAccount-microservice
### GraphQL Controller Documentation

This GraphQL controller is a Spring MVC controller responsible for handling GraphQL queries and mutations. It allows clients to request specific data and execute operations (mutations) on the server.

#### GraphQL Queries
To make a GraphQL query, you can use the built-in GraphiQL interface or other tools like Postman. The URL to access the GraphiQL interface (in a local environment) is:
```
http://localhost:8081/graphiql
```

Here are examples of common GraphQL queries:

1. **Query by ID:**
   You can request specific data fields by specifying them in the query.
   ```graphql
   query {
     accountById(id: "8bdb25bd-2651-4cf0-b241-c3d9b8a580cf") {
       balance,
       id
     }
   }
   ```

2. **Query List of Accounts:**
   You can also retrieve a list of accounts and specify the fields you want.
   ```graphql
   query {
     accountsList {
       balance,
       id
     }
   }
   ```

> **Note**: In GraphQL, you can choose which fields to include in the response, giving you more flexibility compared to REST, which typically returns the full object unless otherwise specified.

#### GraphQL Mutations
Mutations allow you to perform operations like creating or updating data.

1. **Basic Mutation (Create Account):**
   This mutation creates a new account with specified details such as balance, currency, and type.
   ```graphql
   mutation {
     addAccount(bankAccount: {
       balance: 400,
       currency: "EUR",
       type: "SAVINGS_ACCOUNT"
     }) {
       balance,
       id
     }
   }
   ```

2. **Parameterized Mutation:**
   You can also create a parameterized mutation where values are passed as variables.
   ```graphql
   mutation addAccount($balance: Float, $currency: String, $type: String) {
     addAccount(bankAccount: {
       balance: $balance,
       currency: $currency,
       type: $type
     }) {
       balance,
       id
     }
   }
   ```

#### Benefits of GraphQL over REST
One of the key benefits of using GraphQL instead of REST is that you avoid issues like infinite call loops, which can occur in REST APIs with complex two-way relationships between entities. GraphQL provides more controlled and efficient data fetching, allowing clients to specify exactly what data they need in a single query.