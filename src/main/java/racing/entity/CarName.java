package racing.entity;

public class CarName {
    private final String value;

    public CarName(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("cannot be null or empty.");
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException("cannot be longer than 5 characters.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
