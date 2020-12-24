import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = BCustomDeserializer.class)
public class B extends A {

    private final String type2;

    private final String propertyB;

    @JsonCreator
    public B(@JsonProperty("type2") String type2,
             @JsonProperty("propertyB") String propertyB) {
        super("B");
        this.type2 = type2;
        this.propertyB = propertyB;
    }
}
