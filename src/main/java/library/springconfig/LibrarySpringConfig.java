package library.springconfig;


import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:application.yml")
public class LibrarySpringConfig {


    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().username(environment.getProperty("spring.datasource.username"))
                .driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
                .password(environment.getProperty("spring.datasource.password"))
                .url(environment.getProperty("spring.datasource.url"))
                .build();

    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(environment.getProperty("liquibase.change-log"));
        liquibase.setDataSource(dataSource());
        return liquibase;
    }
}
