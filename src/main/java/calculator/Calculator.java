package calculator;

public class Calculator {

    private Operator operator;

    public Calculator() {
        this.operator = Operator.getInstance();
    }

    public Calculator(Operator operator) {
        this.operator = operator;
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
        throw new IllegalArgumentException();
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Const.NULL_ERROR_MSG);
        }
        if (input.length() < 1) {
            throw new IllegalArgumentException(Const.EMPTY_ERROR_MSG);
        }
    }

    private void validateArray(String[] array) {
        // 연산 가능한 최소한의 length 는 3이다. (e.g: 1 + 2)
        if (array.length < 3) {
            throw new IllegalArgumentException(Const.LESS_THAN_3_ERROR_MSG);
        }

        // 마지막이 숫자로 끝나려면, array 의 length 가 홀수여야 한다.
        if (array.length % 2 == 0) {
            throw new IllegalArgumentException(Const.ODD_ERROR_MSG);
        }
    }

    private String[] parseInput(String input) {
        return input.split(Const.SPLIT_REGEX);
    }

    public int calculate(String input) {
        validateInput(input);
        String[] array = parseInput(input);
        validateArray(array);

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
