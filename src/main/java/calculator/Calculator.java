package calculator;

public class Calculator {
    int calculate(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return Operator.add(operand1, operand2);
        }
        if (operator.equals("-")) {
            return Operator.subtract(operand1, operand2);
        }
        if (operator.equals("*")) {
            return Operator.multiply(operand1, operand2);
        }
        if (operator.equals("/")) {
            return Operator.divide(operand1, operand2);
        }
        throw new IllegalArgumentException();
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null");
        }
        if (input.length() < 1) {
            throw new IllegalArgumentException("입력 값이 빈 공백 문자");
        }
    }

    private void validateArray(String[] array) {
        // 연산 가능한 최소한의 length 는 3이다. (e.g: 1 + 2)
        if (array.length < 3) {
            throw new IllegalArgumentException("array 의 길이는 3이상이어야 한다.");
        }

        // 마지막이 숫자로 끝나려면, array 의 length 가 홀수여야 한다.
        if (array.length % 2 == 0) {
            throw new IllegalArgumentException("array 의 길이는 홀수여야 한다.");
        }
    }

    private String[] parseInput(String input) {
        return input.split(" ");
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
