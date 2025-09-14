# Simple Social media REST api 

## **Handling Exceptions with `@ControllerAdvice`**
* [Get Started with Custom Error Handling in Spring Boot (Java)](https://auth0.com/blog/get-started-with-custom-error-handling-in-spring-boot-java/)
* [Spring Boot Error Handling: A Step-by-Step Guide](https://inspector.dev/spring-boot-error-handling-a-step-by-step-guide/)

## [springdoc-openapi v2.8.13](https://springdoc.org/)
* using springdoc swagger api to  automate the generation of API documentation using spring boot projects.

## [Validation in Spring Boot](https://www.baeldung.com/spring-boot-bean-validation)
* Front end validation is never a good option so we need a better way to validate the incoming request.

## [Spring Boot and Content Negotiation - XML and JSON Representations](https://www.springboottutorial.com/spring-boot-content-negotiation-with-xml-json-representations)
A resource can have multiple representations
* XML
* HTML
* JSON

## Internationalization i18n 
* Typically, HTTP request header - `Accept-Language` is used
* Accept-Language indicates natural language and locale that consumer prefers
* [Decoding i18n Challenges in Spring Boot 3: Exploring Internationalization](https://medium.com/yildiztech/decoding-i18n-challenges-in-spring-boot-3-exploring-internationalization-895a4ac627df)
* [Spring Boot internationalization i18n](https://lokalise.com/blog/spring-boot-internationalization/)
* [Guide to Internationalization in Spring Boot](https://www.baeldung.com/spring-boot-internationalization)


## Hateoas 
>     @GetMapping("/users/{id}")
        public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<User> entityModel =  EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

* using hateoas to send navigation links along with the response 
* `User` is wrapped with `EntityModel` 
* Links are added using `WebMvcLinkBuilder` to the `EntityModel`


## Customizing REST api response 
* Customizing field names in response with `@JsonProperty("user_name")`
* Return only selected fields with 
  * **Static Filtering**
    * `@JsonIgnoreProperties({"filed1", "field2"})` class level, `@JsonIgnore` on methods
  * **Dynamic Filtering**
    * `@JsonFilter` with `FilterProvider`

## [Actuator](https://www.baeldung.com/spring-boot-actuators)
monitor and manage your application in production, Monitoring our app, gathering metrics, and understanding traffic or the state of our database becomes trivial with this dependency.
>     management.endpoints.web.exposure.include=*
>     management.endpoint.env.show-values=ALWAYS
