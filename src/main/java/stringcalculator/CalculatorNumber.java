package stringcalculator;

import java.util.Objects;

public class CalculatorNumber {
    private static final String OPERATOR_GROUP = "+-*/";
    private static final int NEXT_INDEX = 1;

    private String[] inputDatas;
    private int index;
    private double sum;

    public CalculatorNumber(String[] inputDatas, int index, double sum) {
        this.inputDatas = inputDatas;
        this.index = index;
        this.sum = sum;
    }

    public double calculate() {
        validateOperator();
        String operator = findOperator();
        return OperatorType.findOperator(operator).calculate(sum, nextNumber());
    }

    private String findOperator() {
        String operator = inputDatas[index];
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException("연산자는 null 이 될 수 없습니다.");
        }
        return operator;
    }

    private void validateOperator() {
        if (!OPERATOR_GROUP.contains(findOperator())) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    private double nextNumber() {
        return Double.parseDouble(inputDatas[index + NEXT_INDEX]);
    }
}
