package stringcalculator;

public class CalculatorNumber {
    private static final String OPERATOR_GROUP = "+-*/";
    private static final String PLUS_OPERATOR = "+";
    private static final String MINUS_OPERATOR = "-";
    private static final String MULTIPLY_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";
    private static final String ZERO_STRING = "0";
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

        if (findOperator().equals(PLUS_OPERATOR)) {
            return plus();
        }

        if (findOperator().equals(MINUS_OPERATOR)) {
            return minus();
        }

        if (findOperator().equals(MULTIPLY_OPERATOR)) {
            return multiply();
        }

        if (findOperator().equals(DIVIDE_OPERATOR)) {
            return divide();
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    private String findOperator() {
        return inputDatas[index];
    }

    private void validateOperator() {
        if (!OPERATOR_GROUP.contains(findOperator())) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    private double plus() {
        return sum + nextNumber();
    }

    private double minus() {
        return sum - nextNumber();
    }

    private double multiply() {
        return sum * nextNumber();
    }

    private double divide() {
        if (inputDatas[index + NEXT_INDEX].equals(ZERO_STRING)) {
            throw new IllegalArgumentException("0 으로 나눌수 없습니다.");
        }
        return sum / nextNumber();
    }

    private double nextNumber() {
        return Double.parseDouble(inputDatas[index + NEXT_INDEX]);
    }
}
