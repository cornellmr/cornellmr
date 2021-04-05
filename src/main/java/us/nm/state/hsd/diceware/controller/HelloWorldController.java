package us.nm.state.hsd.diceware.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

  @RestController
public class HelloWorldController {
    
    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greet() {
      return "Hello, world!";
    }
    
    
}
    
