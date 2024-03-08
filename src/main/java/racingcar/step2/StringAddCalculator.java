package racingcar.step2;

import java.util.List;

public class StringAddCalculator {

    private final int EMPTY_INPUT_RESPONSE = 0;

    private final DelimiterIntegerTokenizer tokenizer;
    private final IntegerCalculator calculator;

    public StringAddCalculator(DelimiterIntegerTokenizer tokenizer, IntegerCalculator calculator) {
        this.tokenizer = tokenizer;
        this.calculator = calculator;
    }

    public int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return EMPTY_INPUT_RESPONSE;
        }

        List<Integer> tokens = tokenizer.tokenize(input);
        return calculator.sum(tokens);
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
}
