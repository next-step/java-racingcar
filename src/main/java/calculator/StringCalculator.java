package calculator;


import static calculator.NumberParser.*;

public class StringCalculator {
    public long calculate(String inputText) {
        checkTextNullOrEmpty(inputText);
        return calculateText(toSplitStringList(inputText));
    }

    private long calculateText(String[] parseNumber) {
        long calculateResult = parseText(parseNumber[0]);
        long nextInput = 0;
        Operator operator = null;

        for (int i = 0; i < parseNumber.length - 1; i += 2) {
            operator = Operator.findOperator(parseNumber[i + 1]);
            nextInput = parseText(parseNumber[i + 2]);
            calculateResult = operator.calculate(calculateResult, nextInput);
        }
        return calculateResult;
    }
}
