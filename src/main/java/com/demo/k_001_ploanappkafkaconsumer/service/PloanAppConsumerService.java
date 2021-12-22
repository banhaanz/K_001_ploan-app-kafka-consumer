package com.demo.k_001_ploanappkafkaconsumer.service;

import com.demo.k_001_ploanappkafkaconsumer.model.SampleResponse;
import com.demo.k_001_ploanappkafkaconsumer.property.KafkaProperties;
import com.demo.k_001_ploanappkafkaconsumer.util.JsonUtils;
import com.kiatnakinbank.naos.common.framework.exception.NAOSServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PloanAppConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(PloanAppConsumerService.class);

    @Autowired
    private JsonUtils jsonUtils;

    @Autowired
    private KafkaProperties kafkaConsumerProperties;

    @KafkaListener(topics= "${kafka.consumer.ploan-app.topic}",  groupId = "${kafka.consumer.ploan-app.group.id}")
    public void ploanAppConsume(String message) throws IOException {
        try {
            logger.info("===== Start Consume message from topic:{} =====", kafkaConsumerProperties.getKafkaPloanAppTopic());
            logger.info("Consume message : " + message);
            SampleResponse sampleResponse = jsonUtils.convertJsonToObjectResponse(message, SampleResponse.class);
            logger.info("converted data : {}", sampleResponse.toString());

            //--> next action..

            logger.info("===== End Consumer message =====");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new NAOSServiceException("statusCodeProperties.getStatusCodeServiceFail()", "fail", ex);
        }
    }

    @KafkaListener(topics= "${kafka.consumer.ploan-app.topic}",  groupId = "${kafka.consumer.ploan-partner.group.id}")
    public void ploanPartnerConsume(String message) throws IOException {
        try {
            logger.info("===== Start Consume message from topic:{} =====", kafkaConsumerProperties.getKafkaPloanAppTopic());
            logger.info("Consume message : " + message);
            SampleResponse sampleResponse = jsonUtils.convertJsonToObjectResponse(message, SampleResponse.class);
            logger.info("converted data : {}", sampleResponse.toString());

            //--> next action..

            logger.info("===== End Consumer message =====");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new NAOSServiceException("statusCodeProperties.getStatusCodeServiceFail()", "fail", ex);
        }
    }
}
