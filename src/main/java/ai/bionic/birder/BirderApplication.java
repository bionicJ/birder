package ai.bionic.birder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ai.bionic.birder.login.EnableLoginModule;
import ai.bionic.birder.user.EnableUserModule;

@SpringBootApplication
@EnableUserModule
@EnableLoginModule
public class BirderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirderApplication.class, args);
	}

}
