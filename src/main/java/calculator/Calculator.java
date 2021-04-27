package calculator;

public class Calculator {
    public static String[] isBlank(String input) {
        if(input == null || input.trim().isEmpty()) throw new IllegalArgumentException("input is null or blank");
        else return input.split(" ");
    }

}
