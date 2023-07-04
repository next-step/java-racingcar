package calculator;

public class Calculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty())
            return 0;

        return Integer.parseInt(input);
    }
}
