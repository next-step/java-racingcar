package study;

public final class Utils {
    public static boolean isNullOrEmptyString(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isEven(int number) {
        return (number % 2) == 0;
    }
}
