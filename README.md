# Spring Cloud GCP: Setting Up A Cloud SQL Database
This is the repository for the LinkedIn Learning course `Spring Cloud GCP: Setting Up A Cloud SQL Database`. The full course is available from [LinkedIn Learning](https://linkedin.com/learning/).

## COURSEDESCRIPTION
Cloud SQL is one of the most frequently used products on Google Cloud Platform (GCP). This fully managed relational database service for MySQL, PostgreSQL, and SQL Server provides an alternative to configuring and hosting your own database. Plus, it's relatively easy to integrate Cloud SQL with a Spring Boot app, due to the use of Spring Data Cloud SQL and the Spring Data Java Persistence API. In this course, learn how to set up a Cloud SQL database and effectively test your Spring Boot application. Instructor Cecili Reid discusses why and when to leverage a hosted cloud technology. Cecili steps through how to set up your environment and application to use Cloud SQL, as well as how to connect to the database and send requests. To wrap up, she covers how to incorporate unit and integration testing while mitigating costs.

## Instructions
This repository has branches for each of the videos in the course. You can use the branch pop up menu in github to switch to a specific branch and take a look at the course at that stage, or you can add `/tree/BRANCH_NAME` to the URL to go to the branch you want to access.

## Branches
The branches are structured to correspond to the videos in the course. The naming convention is `CHAPTER#_MOVIE#`. As an example, the branch named `02_03` corresponds to the second chapter and the third video in that chapter. 
Some branches will have a beginning and an end state. These are marked with the letters `b` for "beginning" and `e` for "end". The `b` branch contains the code as it is at the beginning of the movie. The `e` branch contains the code as it is at the end of the movie. The `master` branch holds the final state of the code when in the course.

## Installing
1. To use these exercise files, you must have the following installed:
	- Java at least version 1.8
	- Maven
	- Favorite editor or IDE
	- A terminal or way to run the Java application
	- Postman or another GUI or CLI to send requests to an API
2. Clone this repository into your local machine using the terminal (Mac), CMD (Windows), or a GUI tool like SourceTree.
3. Checkout the beginning branch of a particular video
4. Follow along with the video on specific changes
5. `mvn clean install` to build the project and install dependencies
6. `mvn spring-boot:run` to run the application locallymk
