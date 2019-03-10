package racinggame.utils;

public class StringUtils {
    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
    }

    public static String repeat(String character, int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(character);
        }
        return sb.toString();
    }
}
