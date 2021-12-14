package com.netcracker.accountingofstudents;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Driver {

    private static final String URL = "jdbc:mysql://localhost:3306/bookofstudent";
    private static final String USER = "root";
    private static final String PASSWORD = "3LOU_777";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }


    @Bean
    public static DataSource getDatasource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setURL(URL);
        return dataSource;
    }
}



