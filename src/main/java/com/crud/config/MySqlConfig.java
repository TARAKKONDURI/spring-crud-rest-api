package com.crud.config;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

//@Configuration
//@EnableConfigurationProperties
//@EnableTransactionManagement
//@EnableJpaRepositories(
		//basePackages = "com.crud.repo",
       //  entityManagerFactoryRef = "mySqlEntityManagerFactory",
       //  transactionManagerRef = "mySqlTransactionManager"
		//)
		public class MySqlConfig {
			/*
			 * 
			 * @Autowired private Pro pro;
			 * 
			 * @ConfigurationProperties(prefix = "spring.datasource.db2")
			 * 
			 * @Bean(name = "mySqlDataSource") public DataSource dataSource() { return
			 * DataSourceBuilder.create() .url(pro.getUrl()) .username(pro.getUsername())
			 * .password(pro.getPassword()) .driverClassName(pro.getDriverClassName())
			 * .build(); }
			 * 
			 * @Primary
			 * 
			 * @Bean(name = "mySqlEntityManagerFactory") public
			 * LocalContainerEntityManagerFactoryBean
			 * entityManagerFactory(EntityManagerFactoryBuilder builder,
			 * 
			 * @Qualifier(value = "mySqlDataSource") DataSource dataSource) { return
			 * builder.dataSource(dataSource)
			 * .packages("com.crud.model.mysql","com.crud.entity") .persistenceUnit("mySql")
			 * .build(); }
			 * 
			 * @Bean(name = "mySqlTransactionManager") public PlatformTransactionManager
			 * transactionManager(
			 * 
			 * @Qualifier("mySqlEntityManagerFactory") EntityManagerFactory
			 * entityManagerFactory) { return new
			 * JpaTransactionManager(entityManagerFactory); }
			 * 
			 */}
