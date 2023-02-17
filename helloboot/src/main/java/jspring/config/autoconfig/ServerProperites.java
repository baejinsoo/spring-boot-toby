package jspring.config.autoconfig;

import jspring.config.MyConfigurationProperties;
import org.springframework.stereotype.Component;

@MyConfigurationProperties(prefix="server")
public class ServerProperites {
    private String contextPath;

    private int port;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
