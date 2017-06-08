# Initialize DB 

DROP DATABASE IF EXISTS pos;
CREATE DATABASE pos CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
USE pos;

DROP USER 'pos'@'localhost';
CREATE USER 'pos'@'localhost' IDENTIFIED BY 'DrQi3kclsqO4v';
GRANT  ALL PRIVILEGES ON pos.* TO 'pos'@'localhost';

# Technology

1. Spring Boot - https://projects.spring.io/spring-boot/
2. MyBatis - http://www.mybatis.org/mybatis-3/ | http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/index.html
3. Flyway - https://flywaydb.org/
4. Lombok- https://projectlombok.org/

# Run

$ gradlew bootRun