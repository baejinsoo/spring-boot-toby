package jspring.config.autoconfig;

import jspring.config.ConditionalMyOnClass;
import jspring.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 어떤걸 기준으로 tomcat으로 띄울지 jetty로 띄울지 결정하면 좋을까?
 * => 어떤 라이브러리가 이 프로젝트에 포함되어 잇는가?
 */
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}
