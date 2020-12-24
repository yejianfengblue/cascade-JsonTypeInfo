import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class C extends B {

    private final String propertyC;

    @JsonCreator
    public C(@JsonProperty("type") String type,
             @JsonProperty("type2") String type2,
             @JsonProperty("propertyB") String propertyB,
             @JsonProperty("propertyC") String propertyC) {
        super(type, type2, propertyB);
        this.propertyC = propertyC;
    }
}
