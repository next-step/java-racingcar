package study.validation;

public class Validation {

    public static void checkValue(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("input Value is null or blank");
            throw new IllegalArgumentException("input Value is null or blank");
        }
    }
}
