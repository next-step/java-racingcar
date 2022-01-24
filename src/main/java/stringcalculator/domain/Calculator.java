package stringcalculator.domain;

import java.util.List;

public class Calculator {

    private int result;
    private final List<String> userInput;

    private Calculator(final List<String> userInput) {
        this.userInput = userInput;
        this.result = 0;
        process();
    }

    public static Calculator from(final List<String> userInput) {
        return new Calculator(userInput);
    }

    private void process() {
        this.result = Integer.parseInt(userInput.get(0));

        for (int index = 1; index < userInput.size() - 1; index += 2) {
            this.result = Operator.from(userInput.get(index))
                    .operate(this.result, Integer.parseInt(userInput.get(index + 1)));
        }
    }

    public int getResult() {
        return this.result;
    }

}
