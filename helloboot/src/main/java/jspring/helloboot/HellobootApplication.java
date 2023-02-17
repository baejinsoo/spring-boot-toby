package jspring.helloboot;

import jspring.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class HellobootApplication {

//	@Bean
//	ApplicationRunner applicationRunner(Environment env) {
//		return args -> {
//			// 우선순위
//			// -Dmy.name=SystemProperty - environment variable - application properties
//			String name = env.getProperty("my.name");
//			System.out.println("my.name: "+name);
//		};
//	}
	public static void main(String[] args) {
//		MySpringApplication.run(HellobootApplication.class, args);
		 SpringApplication.run(HellobootApplication.class, args);
	}

}

/**
 *
 */
