# spring-boot

## Micro Service Architecture
 - <img src="https://github.com/eshita19/spring-boot/blob/master/screenshots/microservice_archeticture.png"></img>
 
## Spring boot 
  - Spring Boot dependencies use the org.springframework.boot groupId. 
  - Maven POM file inherits from the spring-boot-starter-parent project and declares dependencies to one or more “Starters”.
  - If you are on a Mac and use Homebrew, you can install the Spring Boot CLI by using the following commands:
    `brew tap pivotal/tap`
    `brew install springboot`
 - Annotation:
   1. `@EnableAutoConfiguration`: Enable auto-configuration of the Spring Application Context, attempting to guess and
    configure beans that you are likely to need. Auto-configuration classes are usually applied based on your classpath and  what beans you have defined. For example, if you have  tomcat-embedded.jar on your classpath you are likely to want a TomcatServletWebServerFactory.
   2. `@SpringBootApplication`: Combination of `@Combination`, `@component-scan` & `@EnableAutoConfiguration`.

    
    

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
  
