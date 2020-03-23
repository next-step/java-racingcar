package utils;

public class RacingCarUtils {

    public static void validateCarName(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("car name is null or empty.");
        }
    }
}
