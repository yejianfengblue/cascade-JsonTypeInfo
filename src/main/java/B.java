import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = C.class, name = "YY")})
public class B extends A {

    private final String propertyB;

    @JsonCreator
    public B(@JsonProperty("propertyB") String propertyB) {
        super(TypeX.X);
        this.propertyB = propertyB;
    }

    public B(MyType type, String propertyB) {
        super(type);
        this.propertyB = propertyB;
    }

}
