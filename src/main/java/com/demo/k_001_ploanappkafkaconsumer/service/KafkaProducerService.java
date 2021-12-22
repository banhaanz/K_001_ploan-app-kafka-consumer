package com.demo.k_001_ploanappkafkaconsumer.service;

import com.demo.k_001_ploanappkafkaconsumer.property.KafkaProperties;
import com.kiatnakinbank.naos.common.framework.exception.NAOSServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaProperties kafkaProperties;

    public void sendKafkaPloanAppTopic(String data) {
        sendKafkaTopic(data, kafkaProperties.getKafkaPloanAppTopic());
    }

    public void sendKafkaTopic(String jsonPayload, String topic) {
        try {
            kafkaTemplate.send(topic, jsonPayload).completable();
            logger.info("SEND message finished to topic : {} , payload : {}", topic, jsonPayload);
        } catch (NAOSServiceException ex) {
            logger.error("kafka can't produce message , error : {}",ex.getMessage());
            throw ex;
        }catch (Exception ex) {
            logger.error("kafka can't produce message , error : {}",ex.getMessage());
            throw new NAOSServiceException("statusCodeProperties.getStatusCodeServiceFail()", "fail", ex);
        }
    }
}
