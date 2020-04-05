# shard-pay
pronounced like
![Shar-Pei](https://upload.wikimedia.org/wikipedia/commons/0/05/Adult_sharpei.jpg)

### Description
This is an implementation of imaginary payment service that works with sharded database. The serice receives list of payments and responds with total amount of payments of specified payer.
Payment has following fields:
* payer (who sends the money)
* payee (who receives the money)
* amount (of money, in cents)

### Table structure
`CREATE TABLE payment (
    payer bigint,
    payment_id serial,
    payee bigint NOT NULL,
    amount bigint NOT NULL,
    PRIMARY KEY(payer, payment_id)
);`

### Why bother with sharding?
To spread load.

### Should I use Cassandra for this?
Payments come in bulk. There is no way to de-duplicate records in case of failure, because they don't have any external id or timestamp. Transactions would be really helpful.

### Should I use PostgreSQL partitioning for this?
Partitioning != sharding. Partitioning works on a single PostgreSQL server out-of-the-box, but sharding (on multiple nodes) doesn't. (according to https://www.youtube.com/watch?v=JWQVDKw1HVk).

### Another approaches?
Application-level sharding.

### How to distribute payments?
All payments of one payer should reside on one shard. It's for faster grouping by payer. So, we have to leverage some hash-based partitioning.

### Existing libraries for database sharding?
Sharding-JDBC from Apache ShardingSphere(Incubator) project. It works with any database and popular ORMs. It also offers distributed XA transactions (2PC). 

### Chosen set of tools
Java 11, Spring MVC, PostgreSQL, jOOQ, Sharding-JDBC, Gradle.

### How to run
1. Configure and run three PostgreSQL servers (or more).
2. Execute create_table.sql on each server.
3. Configure database connection settings in application.properties. You can specify any number of shards. Just don't forget to change algorithm-expression accordingly.
4. Run ShardpayApplication.
5. (Optional) Run ShardpayApplicationTests.

### What wasn't done
* Distributed transactions.
* API Authentication & Authorization.
* Unit-tests (only basic functional test was written).
