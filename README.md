# Database Proxy Utility

This project provides a simple `DatabaseProxy` utility class for querying data from a database using `JdbcTemplate` in Spring. The class abstracts away the complexity of manually handling database connections and result sets, allowing for easier querying and mapping of data.

## Features

- **Query with `JdbcTemplate`**: Query the database by providing a query string and a `JdbcTemplate` instance.
- **Query with `DataSource`**: Alternatively, query the database by providing a query string and a `DataSource` instance.
- **Entity Mapping**: Automatically maps the results from the query to the custom `Entity` object, which holds the results in a flexible format.

## Classes

### 1. `DatabaseProxy`
This is the core utility class that provides static methods for querying the database.

#### Methods
- `query(String q, JdbcTemplate jdbcTemplate)`: Takes a SQL query and a `JdbcTemplate` object to execute the query and map the result set to an `Entity` list.
- `query(String q, DataSource dataSource)`: Takes a SQL query and a `DataSource` object to create a `JdbcTemplate` and execute the query, mapping the result set to an `Entity` list.

### 2. `DatabaseProxy.Entity`
This class represents a single database row. It contains a list of `Data` objects.

#### Methods
- `addData(Data data)`: Adds a `Data` object to the `Entity`.
- `toString()`: Provides a readable string representation of the entity by showing each column name and its corresponding value.

### 3. `DatabaseProxy.Entity.Data`
This class represents a single column of a row in the database.

#### Constructor
- `Data(String column, String value)`: Takes the column name and its corresponding value.

### 4. `DatabaseProxy.EntityMapper`
This class implements `RowMapper<Entity>` to map each row of a `ResultSet` to an `Entity` object.

## Requirements

- Java 8+
- Spring Framework 5.x+
- A working database connection configured in your Spring project.

## Usage

1. **Using `JdbcTemplate`**:
   ```java
   List<Entity> result = DatabaseProxy.query("SELECT * FROM my_table", jdbcTemplate);
   result.forEach(System.out::println);
   ```  
  
2. **Using `DataSource`**:  
  ```java
  List<Entity> result = DatabaseProxy.query("SELECT * FROM my_table", dataSource);
  result.forEach(System.out::println);
  ```
