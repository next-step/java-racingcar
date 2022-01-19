package calculator;

import java.util.List;

public class Calculator {

    private int result;
    private final List<String> splitedInput;

    public Calculator(List<String> splitedInput) {
        this.splitedInput = splitedInput;
        result = Integer.parseInt(splitedInput.get(0));
    }

    private void addNumbers(int number) {
        result += number;
    }

    private void subtractNumbers(int number) {
        result -= number;
    }
}
