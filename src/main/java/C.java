import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class C extends B {

    private final String propertyC;

    @JsonCreator
    public C(@JsonProperty("propertyB") String propertyB,
             @JsonProperty("propertyC") String propertyC) {
        super("C", propertyB);
        this.propertyC = propertyC;
    }
}
