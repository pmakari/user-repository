#Java Meetup Registration
Simple web application which registers users for java Meetup

#Installation
Clone the project and run this command
`mvn spring-boot:run`
For packaging and testing the project run the following command
`mvn clean package` 
For running the project after packaging use the following command
` java -jar target/k15t-full-stack-dev-tasks.jar 
` 
#Technology stack
**Java 8**
**Maven**
**SpringBoot 1.4.7**
**Flyway**
**Project Lombok**

#Prerequisites
**Maven**
**JDK 8**


#Description
 Flyway added for database migration and versioning
 Used HSQL embedded database 
 There are three profiles for application (**prod**,**dev**,**test**), the default 
 profile is **dev**. To change the profile use the command like arguments :
` java -jar target/k15t-full-stack-dev-tasks.jar -Dspring.profiles.active=prod
`
Tip : don't forget to add the datasource configs in application-prod.properties, in case you want to use prod profile.