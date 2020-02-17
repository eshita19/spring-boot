# spring-boot

## Micro Service Architecture
 - <img src="https://github.com/eshita19/spring-boot/blob/master/screenshots/microservice_archeticture.png"></img>

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
  
