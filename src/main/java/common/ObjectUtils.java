package common;

public class ObjectUtils {
    private ObjectUtils() {
    }

    public static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }
}
