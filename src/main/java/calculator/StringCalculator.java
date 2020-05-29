package calculator;

public class StringCalculator {

    public int add(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }


    public boolean isBlank(String input) {
        return input == null || input.equals("");
    }
}