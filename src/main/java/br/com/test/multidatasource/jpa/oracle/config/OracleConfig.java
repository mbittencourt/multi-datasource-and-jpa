package br.com.test.multidatasource.jpa.oracle.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "oracleEntityManagerFactory",
		transactionManagerRef = "oracleTransactionManager",
		basePackages = {"br.com.test.multidatasource.jpa.oracle"})
public class OracleConfig {

	@Primary // Arbitrarily making this as Primary
	@Bean(name = "oracleDataSource")
	@ConfigurationProperties(prefix = "spring.oracle.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary // Arbitrarily making this as Primary
	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("oracleDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("br.com.test.multidatasource.jpa.oracle.entity")
				.build();
	}

	@Primary // Arbitrarily making this as Primary
	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager oracleTransactionManager(@Qualifier("oracleEntityManagerFactory") EntityManagerFactory oracleEntityManagerFactory) {
		return new JpaTransactionManager(oracleEntityManagerFactory);
	}

	@Bean
	public DataSourceInitializer oracleDataSourceInitializer(@Qualifier("oracleDataSource") DataSource oracleDataSource) {
		DataSourceInitializer oracleDataSourceInitializer = new DataSourceInitializer();
		oracleDataSourceInitializer.setDataSource(oracleDataSource);
		return oracleDataSourceInitializer;
	}

}
