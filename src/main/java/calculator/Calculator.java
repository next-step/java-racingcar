package calculator;

public class Calculator {
    int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }

    int calculate(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return add(operand1, operand2);
        }
        if (operator.equals("-")) {
            return subtract(operand1, operand2);
        }
        if (operator.equals("*")) {
            return multiply(operand1, operand2);
        }
        if (operator.equals("/")) {
            return divide(operand1, operand2);
        }
        throw new IllegalArgumentException();
    }

    void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null");
        }
        if (input.length() < 1) {
            throw new IllegalArgumentException("입력 값이 빈 공백 문자");
        }
    }

    void validateArr(String[] arr) {
        // 연산 가능한 최소한의 length 는 3이다. (e.g: 1 + 2)
        if (arr.length < 3) {
            throw new IllegalArgumentException("arr 의 길이는 3이상이어야 한다.");
        }

        // 마지막이 숫자로 끝나려면, arr 의 length 가 홀수여야 한다.
        if (arr.length % 2 == 0) {
            throw new IllegalArgumentException("arr 의 길이는 홀수여야 한다.");
        }
    }

    String[] parseInput(String input) {
        return input.split(" ");
    }

    public int calculate(String input) {
        validateInput(input);
        String[] arr = parseInput(input);
        validateArr(arr);

        int accumulatedVal = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                // validateArr 에서 arr 의 length 가 3 이상의 홀수임을 체크했으므로,
                // arr[i + 1]의 ArrayIndexOutOfBoundsException 을 걱정하지 않아도 된다.
                accumulatedVal = calculate(accumulatedVal, Integer.parseInt(arr[i + 1]), arr[i]);
            }
        }
        return accumulatedVal;
    }
}
