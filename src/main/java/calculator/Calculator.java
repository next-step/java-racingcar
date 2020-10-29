package calculator;

public class Calculator {

    private Operator operator;

    public Calculator() {
        this.operator = Operator.getInstance();
    }

    public Calculator(Operator operator) {
        this.operator = operator;
    }

    private String[] parseInput(String input) {
        return input.split(Const.SPLIT_REGEX);
    }

    int calculate(int operand1, int operand2, String operatorStr) {
        if (operatorStr.equals(Const.ADDITION)) {
            return operator.add(operand1, operand2);
        }
        if (operatorStr.equals(Const.SUBTRACTION)) {
            return operator.subtract(operand1, operand2);
        }
        if (operatorStr.equals(Const.MULTIPLICATION)) {
            return operator.multiply(operand1, operand2);
        }
        if (operatorStr.equals(Const.DIVISION)) {
            return operator.divide(operand1, operand2);
        }
        throw new IllegalArgumentException(Const.BAD_OPERATOR_ERROR_MSG);
    }

    public int calculate(String input) {
        Validator validator = Validator.getInstance();
        validator.validateInput(input);
        String[] array = parseInput(input);
        validator.validateArray(array);

        int accumulatedVal = Integer.parseInt(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (i % 2 == 1) {
                // validateArray 에서 array 의 length 가 3 이상의 홀수임을 체크했으므로,
                // arr[i + 1]의 ArrayIndexOutOfBoundsException 을 걱정하지 않아도 된다.
                accumulatedVal = calculate(accumulatedVal, Integer.parseInt(array[i + 1]), array[i]);
            }
        }
        return accumulatedVal;
    }
}
