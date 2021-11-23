package step2;

import java.util.Objects;

public class StringCalculator {

    private static final String IAE_MESSAGE = "사칙연산 기호를 확인해주세요 :(";
    private static final int INDEX_TO_GET_FIRST_VALUE = 0;
    private static final int INDEX_TO_START_CALCULATE = 1;
    private static final int NUMBER_OF_UNITS_TO_CALCULATE = 2;
    private static final int ADDITIONAL_INDEX_TO_GET_VALUE = 1;

    private int result = 0;

    public void setResult(int result) {
        this.result = result;
    }
    public int getResult() {
        return result;
    }

    public int calculate(String data) {
        String[] splitData = data.split(" ");
        result = Integer.parseInt(splitData[INDEX_TO_GET_FIRST_VALUE]);

        for (int i = INDEX_TO_START_CALCULATE; i < splitData.length; i += NUMBER_OF_UNITS_TO_CALCULATE) {
            operate(getOperation(splitData[i]), splitData[i + ADDITIONAL_INDEX_TO_GET_VALUE]);
        }

        return result;
    }

    public StringCalculatorOperation getOperation(String operationString) {
        if (Objects.isNull(operationString)) {
            throw new IllegalArgumentException(IAE_MESSAGE);
        }

        switch (operationString) {
            case "+": return StringCalculatorOperation.ADD;
            case "-": return StringCalculatorOperation.SUB;
            case "*": return StringCalculatorOperation.MUL;
            case "/": return StringCalculatorOperation.DIV;
            default: throw new IllegalArgumentException(IAE_MESSAGE);
        }
    }

    public void operate(StringCalculatorOperation operation, String value) {
        switch (operation) {
            case ADD: add(value); break;
            case SUB: sub(value); break;
            case MUL: mul(value); break;
            case DIV: div(value); break;
        }
    }

    public void add(String value) {
        result += Integer.parseInt(value);
    }

    public void sub(String value) {
        result -= Integer.parseInt(value);
    }

    public void mul(String value) {
        result *= Integer.parseInt(value);
    }

    public void div(String value) {
        result /= Integer.parseInt(value);
    }

}
