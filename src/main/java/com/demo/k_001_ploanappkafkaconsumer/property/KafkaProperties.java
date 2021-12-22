package com.demo.k_001_ploanappkafkaconsumer.property;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class KafkaProperties {
    @Value("${kafka.consumer.ploan-app.topic}")
    private String kafkaPloanAppTopic;

    @Value("${kafka.consumer.ploan-app.group.id}")
    private String kafkaPloanAppGroupId;
}
