import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadBJsonToA {

    @Test
    void whenReadBJsonToA_thenObjectIsInstanceOfB() throws JsonProcessingException {

        String json = "{\n" +
                       "  \"type\" : \"B\",\n" +
                       "  \"type2\" : \"D\",\n" +
                       "  \"propertyB\" : \"b\"\n" +
                       "}";

        ObjectMapper objectMapper = new ObjectMapper();
        A a = objectMapper.readValue(json, A.class);
        assertTrue(a instanceof B);
    }

}
