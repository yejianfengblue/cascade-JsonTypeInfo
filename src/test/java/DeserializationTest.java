import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeserializationTest {

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    // pass currently
    @Test
    void whenReadBJsonToA_thenObjectIsInstanceOfB() throws JsonProcessingException {

        String json = "{\n" +
                       "  \"type\" : \"B\",\n" +
                       "  \"type2\" : \"D\",\n" +
                       "  \"propertyB\" : \"b\"\n" +
                       "}";

        A a = objectMapper.readValue(json, A.class);
        assertTrue(a instanceof B);
    }

    // pass currently
    @Test
    void whenReadCJsonToB_thenObjectIsInstanceOfC() throws JsonProcessingException {

        String json = "{\n" +
                      "  \"type\" : \"B\",\n" +
                      "  \"type2\" : \"C\",\n" +
                      "  \"propertyB\" : \"b\",\n" +
                      "  \"propertyC\" : \"c\"\n" +
                      "}";

        B obj = objectMapper.readValue(json, B.class);
        assertTrue(obj instanceof C);
    }

    // fail currently
    @Test
    void whenReadCJsonToA_thenObjectIsInstanceOfC() throws JsonProcessingException {

        String json = "{\n" +
                      "  \"type\" : \"B\",\n" +
                      "  \"type2\" : \"C\",\n" +
                      "  \"propertyB\" : \"b\",\n" +
                      "  \"propertyC\" : \"c\"\n" +
                      "}";

        A obj = objectMapper.readValue(json, A.class);
        assertTrue(obj instanceof B, "obj is not instance of B");
        assertTrue(obj instanceof C, "obj is not instance of C");
    }
}
