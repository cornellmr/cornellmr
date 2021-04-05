package us.nm.state.hsd.diceware.configuration;

import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {
  
  @Bean
  public Random getRandom() {   
    return new SecureRandom();
  }
  
  @Bean
  public ResourceBundle getBundle() { 
    return ResourceBundle.getBundle("word-list");
  }
}
