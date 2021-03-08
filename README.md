# Notes
`@SpringBootApplication` annotation indicates this is a Spring Context file. 
This enables:
- AutoConfiguration: In the Maven Dependencies folder, there is a SpringBootAutoConfigure Jar.
    there are classes that create beans on startup.
    On startup, SpringBoot framework triggers the AutoConfiguration jar, it then looks through
    the classes that are on the classpath (e.g. SpringWebMVC.jar).
- ComponentScan: starts automatically scanning classes in the current package (and subpackage) for any Beans

`@RestController` annotation registers this as a component (bean) and is managed by the Spring Framework

`SpringApplication.run` is used to run a Spring context, and returns an application context


* Spring - Testability: defining correct dependencies (dependency injection), the core of Spring is IOC (Inversion of Control) Spring controls the dependencies 
* SpringBoot - Built upon SpringMVC to include configurations for: Component Scan, Dispatcher Servlet, View Resolver, Web Jars
    When Jars are added to classpath, it automatically configures them
* SpringMVC - Simple methods to develop web applications. Core is the seperation of concerns, i.e. Dispatcher Servlet, ModelAndView and View Resolver


`Actuator` - brings in metrics for the application, simply add dependency to POM