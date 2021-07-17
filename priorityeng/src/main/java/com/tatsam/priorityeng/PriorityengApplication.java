package com.tatsam.priorityeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tatsam.priorityeng.config.ApplicationSecurity;


@EnableJpaRepositories("com.tatsam.*")
@ComponentScan(basePackages = { "com.tatsam.*" })
@EntityScan("com.tatsam.*")   
@SpringBootApplication
@ComponentScan({"com.tatsam.*"})
public class PriorityengApplication {
	
	@Bean
	  public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
	    return new ApplicationSecurity();
	  }

	public static void main(String[] args) {
		SpringApplication.run(PriorityengApplication.class, args);
	}

}
