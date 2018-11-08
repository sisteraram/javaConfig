package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"org.zerock.service", "org.zerock.aop"})
@MapperScan(basePackages = {"org.zerock.mapper"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
public class RootConfig {
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		
		return new DataSourceTransactionManager(dataSource());
	}
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource());
		return factory.getObject();
	}
	
	
	@Bean
	public DataSource dataSource() {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://10.10.10.101:3306/honeyrock?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true");
		config.setUsername("honeyrock");
		config.setPassword("12345678");
		
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
}
