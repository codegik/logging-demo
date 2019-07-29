package com.ilegra.logging.demo.loggingdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class LoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);
    private static final String USERNAME = "username";

    @Scheduled(fixedDelay = 1000)
    public void debugLogging() {
        logger.debug("I'm DEBUG logger");
    }

    @Scheduled(fixedDelay = 1000)
    public void infoLogging() {
        logger.info("I'm INFO logger");
    }


    @Scheduled(fixedDelay = 1500)
    public void userLogging1() {
        final String user = "Silvio.Santos";
        MDC.put(USERNAME, user);
        logger.debug("I'm logger for the user {}", user);
        MDC.remove(USERNAME);
    }


    @Scheduled(fixedDelay = 1400)
    public void userLogging2() {
        final String user = "Fausto.Silva";
        MDC.put(USERNAME, user);
        logger.debug("I'm logger for the user {}", user);
        MDC.remove(USERNAME);
    }
}
