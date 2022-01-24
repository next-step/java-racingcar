package stringcalculator.domain;

import java.util.List;

public class Calculator {

    private final List<String> parsingInputFormat;

    private Calculator(final List<String> parsingInputFormat) {
        this.parsingInputFormat = parsingInputFormat;
    }

    public static Calculator of(final List<String> parsingInputFormat) {
        return new Calculator(parsingInputFormat);
    }

    public int process() {
        int result = Integer.parseInt(parsingInputFormat.get(0));

        for (int index = 1; index < parsingInputFormat.size() - 1; index += 2) {
            result = Operator.of(parsingInputFormat.get(index))
                .operate(result, Integer.parseInt(parsingInputFormat.get(index + 1)));
        }
        return result;
    }
}
