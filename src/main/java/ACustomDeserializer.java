import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ACustomDeserializer extends StdDeserializer<A> {

    private static final long serialVersionUID = -5484277868077095525L;

    public ACustomDeserializer() {
        this(null);
    }

    protected ACustomDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public A deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        JsonNode node = p.getCodec().readTree(p);
        String type = node.get("type").asText();
        String type2 = node.get("type2").asText();
        String propertyB = null;
        String propertyC = null;
        if (node.hasNonNull("propertyB")) {
            propertyB = node.get("propertyB").asText();
        }
        if (node.hasNonNull("propertyC")) {
            propertyC = node.get("propertyC").asText();
        }
        if (type.equals("B")) {
            if (type2.equals("C")) {
                return new C(propertyB, propertyC);
            } else {
                return new B(type2, propertyB);
            }
        } else {
            return null;
        }
    }
}
