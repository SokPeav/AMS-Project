package com.example.demo.Configuration.Controller;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.example.demo.repository")
public class DatabaseConfiguration {

    @Autowired
    private DataSource dataSource;


     @Bean
     public SqlSessionFactoryBean sqlSessionFactoryBean()
     {
         SqlSessionFactoryBean sq = new SqlSessionFactoryBean();
         sq.setDataSource(dataSource);
         return sq;
     }

     @Bean
    public DataSourceTransactionManager dataSourceTransactionManager()
     {
         return new DataSourceTransactionManager(dataSource);
     }

     @Bean
    public DataSource develepment(){

        EmbeddedDatabaseBuilder eb = new EmbeddedDatabaseBuilder();
        eb.setType(EmbeddedDatabaseType.H2);
        eb.addScript("sql/table.sql");
        eb.addScript("sql/data.sql");
        return eb.build();
    }
}


