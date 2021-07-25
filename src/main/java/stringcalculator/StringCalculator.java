package stringcalculator;

import javafx.util.Pair;

public class StringCalculator {
    public int calculate(String input) {
        validate(input);
        InputParser parser = new InputParser(input);
        return calculateAll(parser);
    }

    private int calculateAll(InputParser parser) {
        int result = 0;
        for (Pair<Operator, Integer> pair : parser) {
            Operator operator = pair.getKey();
            Integer operand = pair.getValue();

            result = operator.calculate(result, operand);
        }

        return result;
    }

    private void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다!");
        }
    }
}
