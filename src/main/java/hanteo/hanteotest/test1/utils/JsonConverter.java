package hanteo.hanteotest.test1.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

    public static String convertObjectToJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String result;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("[ERROR] JSON parsing 오류가 발생했습니다.");
        }
        return result;
    }

}
