# spring-boot

## Micro Service Architecture
 - <img src="https://github.com/eshita19/spring-boot/blob/master/screenshots/microservice_archeticture.png"></img>
 
## Spring boot 
  - Spring Boot dependencies use the `org.springframework.boot` groupId. 
  - Maven POM file inherits from the `spring-boot-starter-parent` project and declares dependencies to one or more “Starters”.
  - For generating spring-boot executable jar, add plugin : `spring-boot-maven-plugin` in pom.
  - To automatically restart application on change of files in classpath, use `spring-boot-devtools` pom dependency.
    - application.properties's property: `spring.devtools.restart.enabled`.
    - Exclude resources which should not be watched for restart: `spring.devtools.restart.exclude=static/**,public/**`. 
    - If we want to reload application at specified amount of time. We can update one file - `src/main/resources/.reloadtrigger`.  In the property file : `spring.devtools.restart.trigger-file=.reloadtrigger`. 
  - If you are on a Mac and use Homebrew, you can install the Spring Boot CLI by using the following commands:
    `brew tap pivotal/tap`
    `brew install springboot`
 - Annotations:
   1. `@EnableAutoConfiguration`: Tells Spring Boot to “guess” how you want to configure Spring, based on the jar dependencies that you have added.
   2. `@SpringBootApplication`: Combination of `@Combination`, `@component-scan` & `@EnableAutoConfiguration`. The Root class should be placed at the root package of application. Other classes should be placed in sub packages. 
        - Disbale particular existing config:  @SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
   3. `@RestController`: Combination of `@controller` and `@ResponseBody`.
   4. `@RequestMapping`: For mapping rest endpoints.
 - Commands:
   1. `mvn spring-boot:run` : Run Spring boot application. 
       - This is equivalent to : `java -jar target/myproject-0.0.1-SNAPSHOT.jar`.
       - java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \jar target/myapplication-0.0.1-SNAPSHOT.jar


## Rest API
- https://github.com/eshita19/spring-boot/tree/master/spring-boot-sample

## Eureka
- It is an API discovery service. Multiple microservice can register to Eureka. Each microservice will bee discovery client to Eureka.
- <img src="https://github.com/eshita19/spring-boot/blob/master/screenshots/eureka.png"></img>

## Zuul
 - It is an API gateway(API requests router) which comes with inbuilt Ribbon load balancer.
 - There can be multiple instance of same microservice registered to Eureka. In order to evenly distribute incoming requests to each instance, Zuul's Ribbon load balancer can be used.
 - <img src="https://github.com/eshita19/spring-boot/blob/master/screenshots/zuul.png"></img>
 
 ## H2
  - It is an in-memory database that can be used with spring boot. 
  - https://www.youtube.com/watch?v=6wUQagjtJ4c&t=177s
  
