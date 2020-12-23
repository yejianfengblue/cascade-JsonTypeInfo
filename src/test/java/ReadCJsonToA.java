import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadCJsonToA {

    @Test
    void whenReadCJsonToA_thenObjectIsInstanceOfC() throws JsonProcessingException {

        String json = "{\n" +
                       "  \"type\" : \"B\",\n" +
                       "  \"type2\" : \"C\",\n" +
                       "  \"propertyB\" : \"b\",\n" +
                       "  \"propertyC\" : \"c\"\n" +
                       "}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        A obj = objectMapper.readValue(json, A.class);
        assertTrue(obj instanceof B);
        assertTrue(obj instanceof C);
    }
}
