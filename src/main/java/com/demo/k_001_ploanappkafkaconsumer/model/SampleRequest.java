package com.demo.k_001_ploanappkafkaconsumer.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class SampleRequest {
    private String name;
    private int age;
    private boolean isWork;
    private String message;
}
