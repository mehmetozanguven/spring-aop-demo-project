## Demo Project for Aspect Oriented Programming with Spring Boot using Spring AOP module

- This is demo project for my short blog series about the spring aop module. For more information about the project, click the [link](https://mehmetozanguven.github.io/spring/2020/11/17/aspect-oriented-programming-spring-boot-example-2.html).

### Aspects in the Project
#### @InjectCookieResponse(value)

Method level annotation which injects value to the response cookie

#### @RetryAspect

Method level annotation which re-execute the method if first execution fails

#### Logging Aspect

For any execution of the POST method, log that “POST method called”

#### Tricky Method Aspect

Aspect for trying to find answers to these questions:
- Will aspect work when you call it from another method e.g indirect-call ?
- How Spring AOP actually works
