import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ACustomDeserializer.class)
public abstract class A {

    private final String type;

    public A(String type) {
        this.type = type;
    }
}
