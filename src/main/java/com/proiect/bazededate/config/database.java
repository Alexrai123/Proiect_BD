//package com.proiect.bazededate.config;
//
//import com.mysql.cj.jdbc.MysqlDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@Configuration
//@Profile("oracle")
//public class database {
//    @Bean
//    @ConfigurationProperties("spring.datasource")
//    public DataSource dataSource() throws SQLException {
//        MysqlDataSource dataSource = new MysqlDataSource();
////        dataSource.setURL("jdbc:mysql://msql_container:1433/LigaRugby?user=sa&password=Mypassword!1&useUnicode=true&characterEncoding=UTF-8");
//        dataSource.setURL("jdbc:postgresql://postgresql_data_container:5433/LigaRugby");
//        return DataSourceBuilder
//                .create()
//                .type(MysqlDataSource.class)
//                .build();
//    }
//}