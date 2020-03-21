package calculator;


import static calculator.NumberParser.*;

public class StringCalculator {
    private static final int START_NUMBER = 0;
    private static final int NEXT_OPERATOR = 2;

    public long calculate(String inputText) {
        checkTextNullOrEmpty(inputText);
        return calculateText(toSplitText(inputText));
    }

    private long calculateText(String[] parseNumber) {
        long calculateResult = parseText(parseNumber[START_NUMBER]);
        long nextInput;
        Operator operator;

        for (int i = 0; i < parseNumber.length - 1; i += NEXT_OPERATOR) {
            operator = Operator.findOperator(parseNumber[i + 1]);
            nextInput = parseText(parseNumber[i + 2]);
            calculateResult = operator.calculate(calculateResult, nextInput);
        }
        return calculateResult;
    }
}
