package ai.bionic.birder.login;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ai.bionic.birder.login")
public class LoginModuleConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(LoginModuleConfiguration.class);

  @PostConstruct
  public void postConstruct(){
    logger.info("LOGIN MODULE LOADED!");
  }

}