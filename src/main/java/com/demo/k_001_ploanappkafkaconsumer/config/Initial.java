package com.demo.k_001_ploanappkafkaconsumer.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Initial implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Initial.class);

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("----------------------------------------------------------------------");
        LOGGER.info("run ");
        LOGGER.info("----------------------------------------------------------------------");
    }

}
