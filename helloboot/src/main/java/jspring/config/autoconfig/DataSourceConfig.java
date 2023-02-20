package jspring.config.autoconfig;

import com.zaxxer.hikari.HikariDataSource;
import jspring.config.ConditionalMyOnClass;
import jspring.config.EnableMyConfiguratioProperties;
import jspring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfiguratioProperties(MyDataSourceProperties.class)
public class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    @ConditionalOnMissingBean
    DataSource hikariDataSource(MyDataSourceProperties properties) {
        HikariDataSource dataSource1 = new HikariDataSource();

        dataSource1.setDriverClassName(properties.getDriverClassName());
        dataSource1.setJdbcUrl(properties.getUrl());
        dataSource1.setUsername(properties.getUsername());
        dataSource1.setPassword(properties.getPassword());

        return dataSource1;
    }

    @Bean
    @ConditionalOnMissingBean
    DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }
}
