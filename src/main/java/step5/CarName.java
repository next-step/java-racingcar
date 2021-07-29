package step5;

public class CarName {
    final static int MAX_NAME_LENGTH = 5;

    private final String value;

    public CarName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Boolean isValidCarName(String name) {
        return isShorterThanOrEqualToMaxLength(name);
    }

    private static boolean isShorterThanOrEqualToMaxLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
