package com.example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringCurdApplication {
    public static void main(String[] args) {
    	
    	System.out.println("change 1234");
    	
        SpringApplication.run(SpringCurdApplication.class, args);
    }

}
