package jspring.config.autoconfig;

import jspring.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {


    @Bean
    public ServerProperites serverProperites(Environment environment) {
//        ServerProperites properties = new ServerProperites();
//
//        properties.setContextPath(environment.getProperty("contextPath"));
//        properties.setPort(Integer.parseInt(environment.getProperty("port")));
//        return properties;
        return Binder.get(environment).bind("", ServerProperites.class).get();

    }
}
