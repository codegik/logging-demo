package com.ilegra.logging.demo.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class App {
    public static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        addDefaultProfile(app, args);
        app.run(args);
        logger.info("Aoplication started at {}", new Date());
    }


    private static void addDefaultProfile(SpringApplication app, String[] args) {
        Map<String, Object> defProperties = new HashMap();
        defProperties.put("spring.profiles.default", "local");
        app.setDefaultProperties(defProperties);
    }

}
