package com.demo.k_001_ploanappkafkaconsumer.util;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Date;

@Component
public class JsonUtils {

    public <T> T convertJsonToObjectResponse(String messages, Class<T> type) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>)
                        (jsonElement, type1, context) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                .create();
        T objectResponse = gson.fromJson((String) messages, type);
        return objectResponse;
    }
}
