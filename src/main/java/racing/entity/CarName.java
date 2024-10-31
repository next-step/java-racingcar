package racing.entity;

public class CarName {
    private final String value;

    public CarName(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be null or empty.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
