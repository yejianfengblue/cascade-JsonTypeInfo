import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
              include = JsonTypeInfo.As.EXISTING_PROPERTY,
              property = "type")
@JsonSubTypes({
                      @JsonSubTypes.Type(value = B.class, name = "B")
              })
public abstract class A {

    private final String type;

    public A(String type) {
        this.type = type;
    }
}
