package racingcar.domain;

public class Name {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);

        this.name = name.strip();
    }

    private void validate(String name) {
        if (isNullOrEmpty(name) ||
            isOverLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverLength(String name) {
        return name.length() > MAX_LENGTH;
    }

    private static boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

    public String name() {
        return name;
    }
}
