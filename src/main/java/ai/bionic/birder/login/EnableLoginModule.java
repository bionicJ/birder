package ai.bionic.birder.login;

import java.lang.annotation.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(LoginModuleConfiguration.class)
@Configuration
public @interface EnableLoginModule {
}