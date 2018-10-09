package org.lloydryandavid.loginapp.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@PropertySource("classpath:application.yml")
public class LiquibaseConfig {

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(environment.getProperty("liquibase.change-log"));
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}


