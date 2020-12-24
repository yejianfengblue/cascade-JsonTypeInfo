import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class BCustomDeserializer extends StdDeserializer<B> {

    private static final long serialVersionUID = 8774078974235326314L;

    public BCustomDeserializer() {
        this(null);
    }

    protected BCustomDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public B deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        JsonNode node = p.getCodec().readTree(p);

        String type2 = node.get("type2").asText();
        String propertyB = null;
        String propertyC = null;
        if (node.hasNonNull("propertyB")) {
            propertyB = node.get("propertyB").asText();
        }
        if (node.hasNonNull("propertyC")) {
            propertyC = node.get("propertyC").asText();
        }

        if (type2.equals("C")) {
            return new C(propertyB, propertyC);
        } else {
            return new B(type2, propertyB);
        }

    }
}
