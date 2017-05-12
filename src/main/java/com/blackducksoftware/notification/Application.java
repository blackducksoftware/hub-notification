/*
 * 
 */
package com.blackducksoftware.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class Application.
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"com.blackducksoftware.notification"})
public class Application {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
