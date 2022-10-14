package edu.spring.mvc.project.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //Para habilitar soporte relacionado con transacciones basadas en anotaciones
public class PostgreConfig {

    @Bean
    public DataSource getPostgreDataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://ec2-44-199-22-207.compute-1.amazonaws.com:5432/d1psvnt3ost7up");
        source.setUsername("xtovyvaprrdnxn");
        source.setPassword("05e40cc59f71eb79f53d519421484d77493f433f4c8d26f8115be1ede4bdbc47");
        return source;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getPostgreDataSource());
        return namedParameterJdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getPostgreDataSource());
    }
}