package StringCalculator;

public class StringCalculator {

    public StringCalculator() {}

    public int calculate(String input) {
        input = nullCheck(input);
        input = deleteBlank(input);
        return 0;
    }

    public String deleteBlank(String input) {
        return input.replace(" ", "");
    }

    public String nullCheck(String input) {
        return input == null || input.isBlank() ? "0" : input;
    }
}
