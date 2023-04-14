package racingcar.model;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be null or empty:" + name);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            String message = String.format("Car name cannot exceed %s character: %s", MAX_NAME_LENGTH, name);
            throw new IllegalArgumentException(message);
        }
        this.name = name;
    }

    public String value() {
        return name;
    }
}
