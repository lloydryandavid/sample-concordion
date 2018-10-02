package org.lloydryandavid.concordion.concordionbookapp.database;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ConcordionBookAppDbUtil {

    public static final String databaseUrl = "jdbc:postgresql://localhost:5432/library";
    public static final String username = "postgres";
    public static final String password = "password";
    public static final String dbDriver = "org.postgresql.Driver";

    public static final String clearDbSqlBookTable = "DELETE FROM public.book";

    public void initializeDatabase(){
        DataSource dataSource = DataSourceBuilder.create().url(databaseUrl)
                .username(username)
                .password(password)
                .driverClassName(dbDriver)
                .build();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute(clearDbSqlBookTable);
    }

}
