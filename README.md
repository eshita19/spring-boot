# spring-boot

## Micro Service Architecture
 - <img src="https://github.com/eshita19/spring-boot/blob/master/screenshots/microservice_archeticture.png"></img>
 
## Spring boot 
  - Spring Boot dependencies use the `org.springframework.boot` groupId. 
  - Maven POM file inherits from the `spring-boot-starter-parent` project and declares dependencies to one or more “Starters”.
  - For generating spring-boot executable jar, add plugin : `spring-boot-maven-plugin` in pom.
  - https://github.com/eshita19/spring-boot/blob/master/spring-boot1/pom.xml
  
  - **Auto restart**: Use `spring-boot-devtools` pom dependency.
    - application.properties's property: `spring.devtools.restart.enabled`.(https://github.com/eshita19/spring-boot/blob/master/spring-boot1/src/main/resources/application.properties)
    - Exclude resources which should not be watched for restart: `spring.devtools.restart.exclude=static/**,public/**`. 
    - If we want to reload application at specified amount of time. We can update one file - `src/main/resources/.reloadtrigger`.  In the property file : `spring.devtools.restart.trigger-file=.reloadtrigger`. 
    
  - **Spring boot CLI**: If you are on a Mac and use Homebrew, you can install the Spring Boot CLI by using the following commands:
    `brew tap pivotal/tap`
    `brew install springboot`
    
 - **Annotations**:
   1. `@EnableAutoConfiguration`: Tells Spring Boot to “guess” how you want to configure Spring, based on the jar dependencies that you have added.
   2. `@SpringBootApplication`: Combination of `@Configuration`, `@component-scan` & `@EnableAutoConfiguration`. The Root class should be placed at the root package of application. Other classes should be placed in sub packages. 
        - Disbale particular existing config:  @SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
   3. `@RestController`: Combination of `@controller` and `@ResponseBody`.
   4. `@RequestMapping`: For mapping rest endpoints.
   5. `@EventListener`: makes a method listener of an event.
   6. `@Autowired public MyBean(ApplicationArguments args) {}`: Inject application arguments to a bean.
   
 - **Commands**:
   1.  Run Spring boot application - `mvn spring-boot:run` : 
       - Start application - `java -jar target/myproject-0.0.1-SNAPSHOT.jar`.
       - Detailed Logs: `java -jar myproject-0.0.1-SNAPSHOT.jar --debug`
       - Debug mode: `java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target/myapplication-0.0.1-SNAPSHOT.jar`
       
       
 - **Properties**: https://github.com/eshita19/spring-boot/blob/master/spring-boot1/src/main/resources/application.properties
   1. Enable/disable auto restart: `spring.devtools.restart.enabled`.
   2. Lazy initialization of beans: `spring.main.lazy-initialization=true`
   3. Turn off startup logs: `spring.main.log-startup-info`
  
   
 - **Application Events and Listeners**: https://github.com/eshita19/spring-boot/blob/master/spring-boot1/src/main/java/com/esh/ex/EventListenerEx.java
   _Note_: 	Some events are actually triggered before the ApplicationContext is created, so you cannot register a listener on             those as a `@EventListerner`. You can register them with the `SpringApplication.addListeners(…​)` method
   1. `ApplicationStartingEvent`: Start of a run but before any processing, except for the registration of listeners and initializers.
   2. `ApplicationEnvironmentPreparedEvent`: When the Environment to be used in the context is known but before the context is created.
   3. `ApplicationContextInitializedEvent`: When the ApplicationContext is prepared and ApplicationContextInitializers have been called but before any bean definitions are loaded.
   4. `ApplicationPreparedEvent`:  Just before the refresh is started but after bean definitions have been loaded.
   5. `ApplicationStartedEvent`: After the context has been refreshed but before any application and command-line runners have been called.
   6. `ApplicationReadyEvent`: After any application and command-line runners have been called. It indicates that the application is ready to service requests.
   7. `ApplicationFailedEvent`: An ApplicationFailedEvent is sent if there is an exception on startup.
   8. `@ContextRefreshedEvent`: When the applicationcontext is refreshed.
   9. `@WebServerInitializedEvent`: When the webserver is ready.
   
 - **Passing arguments to application**: https://github.com/eshita19/spring-boot/blob/master/spring-boot1/src/main/java/com/esh/ex/Starter.java
   1. `ApplicationArguments` bean can be injected to access arguments passed to application.
   
 - **Using ApplicationRunner or CommandLineRunner**:https://github.com/eshita19/spring-boot/blob/master/spring-boot1/src/main/java/com/esh/ex/Starter.java
   - Called just before `SpringApplication.run(…​)` completes.
  `
      @Component
      public class MyBean implements CommandLineRunner {
          public void run(String... args) {
              // Do something...
          }
      }
     `

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
  
