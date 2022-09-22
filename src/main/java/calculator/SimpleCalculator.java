package calculator;

import java.util.List;

public class SimpleCalculator implements Calculatable {
    @Override
    public void validateInput(String input) throws IllegalArgumentException {
        if (!input.matches("\\d*[,|:\\d]*")) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
    }

    @Override
    public List<Integer> parseInput(String input) {
        return Calculatable.stringArrayToList(input.split(",|:"));
    }
}
