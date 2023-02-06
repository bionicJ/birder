package ai.bionic.birder.user;

import java.lang.annotation.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(UserModuleConfiguration.class)
@Configuration
public @interface EnableUserModule {
}