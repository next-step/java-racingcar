package calculator;

import java.util.function.BiFunction;

public class StringCalculator {

    private String calcString;

    public StringCalculator(String input) {
        if(!_validator(input)) {
            throw new IllegalArgumentException();
        }
        this.calcString = input;
    }

    public double calculate() {
        return 1;
    }

    private boolean _validator(String input) {
        return !(input == null || input.equals(""));
    }

}
