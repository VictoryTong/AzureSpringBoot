package com.stock.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            System.out.println("In CommandLineRunnerImpl ");

            RestTemplate restTemplate = new RestTemplate();
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            Stock firstStock = new Stock();
            firstStock.setName("Bajaj");
            firstStock.setCurrentPrice(new BigDecimal(13.23));
            firstStock.setLastUpdate(LocalDateTime.now());
            
            HttpEntity<Stock> request = new HttpEntity<>(firstStock,headers);
            
            ResponseEntity<String> response = restTemplate.exchange("http://localhost:8090/api/stocks", HttpMethod.POST, request, String.class);
            
            
        };
    }
	
	@Bean
	public DataSource dataSource() {
		System.out.println("Building datasource");
	   return DataSourceBuilder.create().url("jdbc:mysql://172.17.0.2:3306/stock_db").username("root").password("victorysecret").build();
	}

}
