package com.demo.k_001_ploanappkafkaconsumer.controller;

import com.demo.k_001_ploanappkafkaconsumer.model.SampleRequest;
import com.demo.k_001_ploanappkafkaconsumer.service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoKafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/topic01")
    public @ResponseBody
    void sendMessageToKafkaTopic01(@RequestBody SampleRequest sampleRequest) throws JsonProcessingException {
        String jsonPayload = objectMapper.writeValueAsString(sampleRequest);
        this.kafkaProducerService.sendKafkaPloanAppTopic(jsonPayload);
    }
}
