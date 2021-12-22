package com.demo.k_001_ploanappkafkaconsumer.service;

import com.demo.k_001_ploanappkafkaconsumer.property.KafkaProperties;
import com.kiatnakinbank.naos.common.framework.exception.NAOSServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaProperties kafkaProperties;

    public void sendKafkaPloanAppTopic(String jsonPayload) {
        sendKafkaTopic(kafkaProperties.getKafkaPloanAppTopic(),jsonPayload);
    }

    public void sendKafkaTopic(String topic, String jsonPayload) {
        try {
            kafkaTemplate.send(topic,0,"key1", jsonPayload).completable();
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
