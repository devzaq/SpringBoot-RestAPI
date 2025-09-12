package com.dz.rest.webservices.restful_web_services.greeting;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class GreetingHello {

    private final MessageSource messageSource;

    public GreetingHello(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String HelloWorldInternational(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
