package jspring.config;

import jspring.config.EnableMyAutoConfiguration;
import jspring.config.autoconfig.DispatcherServletConfig;
import jspring.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // class, interface, enum 3가지 종류의 대상에 부여할수 있는 애노테이션 적용
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}
