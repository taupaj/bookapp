## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

<details open="open">
	<ul>
		<li><a href="#prerequisites">Prerequisites</a></li>
	</ul>
</details>

### Prerequisites

*	You need to have **PostgreSQL** installed on your machine to run the application. Using the `pg Admin 4` or on any other client/console, create a database/schema named `bookapp`.

~~~sql
-- CREATE DATABASE bookappp
WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
~~~

After creating the database/schema, you need to add your **PostgreSQL** `username` and `password` in the `application.yml` file on `src/main/resource`. The lines that must be modified are as follows:

```properties
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bookapp
    username: postgres
    password: ####
```