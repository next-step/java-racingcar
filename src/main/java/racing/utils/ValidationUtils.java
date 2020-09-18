package racing.utils;

public class ValidationUtils {
    public static final int NAME_LENGTH = 5;

    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.trim().isEmpty();
    }

    public static boolean validName(String name) {
        if (isBlank(name)) {
            return false;
        }
        if (name.length() > NAME_LENGTH) {
            return false;
        }
        return true;
    }
}
