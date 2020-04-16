package com.example.springbootproject;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.stream.Collectors;


public class GenerateDbSchemaJPAWay {
    public static String ACTION = "update";
    public static String SCHEMA_DDL = "./springboot-project/target/schema-create.sql";

    @Configuration
    public static abstract class PersistenceJPAConfig {

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(MySqlDataSourceLocal());
            em.setPackagesToScan("com.example.springbootproject.controller","com.example.springbootproject.dto",
                    "com.example.springbootproject.entities","com.example.springbootproject.repositories",
                    "com.example.springbootproject.services",
                    "org.axonframework.eventhandling.saga.repository.jpa", "org.axonframework.eventsourcing.eventstore.jpa",
                    "org.axonframework.eventhandling.tokenstore.jpa");
            JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);
            em.setJpaProperties(mySqlAdditionalProperties());
            return em;
        }

        public DataSource OracleDataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
            dataSource.setUrl("jdbc:oracle:thin:@localhost:49161:XE");
            dataSource.setUsername("george");
            dataSource.setPassword("123");
            return dataSource;
        }

        public DataSource MySqlDataSourceLocal() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
            dataSource.setUsername("user");
            dataSource.setPassword("pass");
            return dataSource;
        }



        Properties oracleAdditionalProperties() {
            Properties properties = new Properties();
            properties.setProperty("hibernate.hbm2ddl.auto", "none");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
            properties.setProperty("javax.persistence.schema-generation.scripts.action", ACTION);
            properties.setProperty("javax.persistence.schema-generation.scripts.create-target", SCHEMA_DDL);
            return properties;
        }

        Properties mySqlAdditionalProperties() {
            Properties properties = new Properties();
            properties.setProperty("hibernate.hbm2ddl.auto", "none");
            properties.setProperty("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            properties.setProperty("javax.persistence.schema-generation.scripts.action", ACTION);
            properties.setProperty("javax.persistence.schema-generation.scripts.create-target", SCHEMA_DDL);
            return properties;
        }
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        // delete lines that are marked with FK_DELETE_ME
        File schemaFile = new File(SCHEMA_DDL);
        FileUtils.writeLines(schemaFile, FileUtils.readLines(schemaFile).
                stream().filter(line -> !line.contains("FK_DELETE_ME")).
                map(line -> line.replace(" engine=MyISAM", "")).
                map(line -> line + ";").
                collect(Collectors.toList()));
    }
}

