package com.demo.k_001_ploanappkafkaconsumer.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class SampleResponse implements Serializable {

    private static final long serialVersionUID = 8436231694955615463L;

    private String name;
    private int age;
    private boolean isWork;
    private String message;
}
