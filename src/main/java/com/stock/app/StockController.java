package com.stock.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	
	@Autowired
	private DataSource dataSource;
	
	@GetMapping(value = {"/api/stocks","/api/stocks/{stockid}"})
	public @ResponseBody ResponseEntity<String> getStocks(@PathVariable(required=false) String stockId ) {
		
		if(stockId != null) {
			//query stock information
		}
		else {
			//query all stocks information
		}
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/api/stocks")
    public @ResponseBody ResponseEntity<String>  createStock() {
		
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM stocks");
			while (resultSet.next()) {
				   String column1 = resultSet.getString("name");
				   System.out.println("Column1: "+column1);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PatchMapping(value = "/api/stocks/{stockid}")
	public @ResponseBody ResponseEntity<String> updateStock(@PathVariable(required=true) String stockId) {
		
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@DeleteMapping(value = "/api/stocks/{stockid}")
    public @ResponseBody ResponseEntity<String>  deleteStock(@PathVariable(required=true) String stockId ) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

}
