package com.paymentreminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
/**
 * 
 * @author lalit_bist
 *
 */
@SpringBootApplication
public class PayMentSystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PayMentSystemApplication.class, args);
    }
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PayMentSystemApplication.class);
	}
}
