package calculator;

import java.util.List;

public class SimpleCalculator extends Calculator {
    @Override
    protected void validateInput(String input) throws IllegalArgumentException {
        if (!input.matches("\\d*[,|:\\d]*")) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
    }

    @Override
    protected List<Integer> parseInput(String input) {
        return stringArrayToList(input.split(",|:"));
    }
}
