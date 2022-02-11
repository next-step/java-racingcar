package stringcalculator.domain;

import java.util.List;

public class Calculator {

    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_TWO = 2;
    private final List<String> parsingInputFormat;

    private Calculator(final List<String> parsingInputFormat) {
        this.parsingInputFormat = parsingInputFormat;
    }

    public static Calculator of(final List<String> parsingInputFormat) {
        return new Calculator(parsingInputFormat);
    }

    public int calculateNumbers() {
        int result = Integer.parseInt(parsingInputFormat.get(NUMBER_ZERO));

        for (int index = NUMBER_ONE; index < parsingInputFormat.size() - NUMBER_ONE;
            index += NUMBER_TWO) {
            result = Operator.of(parsingInputFormat.get(index))
                .operate(result, Integer.parseInt(parsingInputFormat.get(index + NUMBER_ONE)));
        }
        return result;
    }
}

