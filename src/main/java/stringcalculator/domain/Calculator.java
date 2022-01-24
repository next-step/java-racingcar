package stringcalculator.domain;

import java.util.List;

public class Calculator {

    private int result;
    private final List<String> parsingInputFormat;

    private Calculator(final List<String> parsingInputFormat) {
        this.parsingInputFormat = parsingInputFormat;
        this.result = 0;
        process();
    }

    public int getResult() {
        return this.result;
    }


    public static Calculator of(final List<String> parsingInputFormat) {
        return new Calculator(parsingInputFormat);
    }

    private void process() {

        this.result = Integer.parseInt(parsingInputFormat.get(0));

        for (int index = 1; index < parsingInputFormat.size() - 1; index += 2) {
            this.result = Operator.of(parsingInputFormat.get(index))
                .operate(this.result, Integer.parseInt(parsingInputFormat.get(index + 1)));
        }


    }
}
