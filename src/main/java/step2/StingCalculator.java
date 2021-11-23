package step2;

import java.util.Objects;

public class StingCalculator {

    private static final String IAE_MESSAGE = "사칙연산 기호를 확인해주세요 :(";
    private int result = 0;

    public void setResult(int result) {
        this.result = result;
    }
    public int getResult() {
        return result;
    }

    public int calculate(String data) {
        String[] splitData = data.split(" ");
        result = Integer.parseInt(splitData[0]);

        for (int i = 1; i < splitData.length; i += 2) {
            operate(getOperation(splitData[i]), splitData[i + 1]);
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
