package ai.bionic.birder.user;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ai.bionic.birder.user")
public class UserModuleConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(UserModuleConfiguration.class);

  @PostConstruct
  public void postConstruct(){
    logger.info("USER MODULE LOADED!");
  }

}