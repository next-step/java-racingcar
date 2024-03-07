package StringCalculator;

public class StringCalculator {

    public StringCalculator() {}

    public int calculate(String input) {
        if (nullCheck(input))
            return 0;
        input = deleteBlank(input);
        return 0;
    }

    public String deleteBlank(String input) {
        return input.replace(" ", "");
    }

    public boolean nullCheck(String input) {
        return input == null || input.isBlank();
    }
}
