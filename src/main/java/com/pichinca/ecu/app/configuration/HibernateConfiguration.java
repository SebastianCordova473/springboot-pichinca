package com.pichinca.ecu.app.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.pichincha.ecu.app.config" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

  @Autowired
  private Environment environment;

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(new String[] { "com.pichinca.ecu.app.model" });
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(
        environment.getRequiredProperty("spring.datasource.driver-class-name"));
    dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
    dataSource.setUsername(
        environment.getRequiredProperty("spring.datasource.username"));
    dataSource.setPassword(
        environment.getRequiredProperty("spring.datasource.password"));
    return dataSource;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put(
        "hibernate.dialect",
        environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
    properties.put(
        "hibernate.show_sql",
        environment.getRequiredProperty("spring.jpa.show-sql"));
    properties.put(
        "hibernate.format_sql",
        environment.getRequiredProperty("spring.jpa.properties.hibernate.format_sql"));
    return properties;
  }

}
