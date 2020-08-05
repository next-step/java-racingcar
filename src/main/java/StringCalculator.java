import java.util.Scanner;

public class StringCalculator {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] splitValue(String value) {
        return value.split(" ");
    }

    public int calculate(String value) {
        verifyInputValue(value);
        return doCalculate(splitValue(value));
    }

    public int doCalculate(String[] values) {
        int result = Integer.parseInt(values[0]);
        for (int i = 0; i < values.length - 2; i += 2) {
            result = verifyOperator(result, values[i + 1].charAt(0), Integer.parseInt(values[i + 2]));
        }
        return result;
    }

    public int verifyOperator(int prev, char operator, int next) {
        if (operator == '+')
            return add(prev, next);
        if (operator == '-')
            return subtract(prev, next);
        if (operator == '*')
            return multiply(prev, next);
        if (operator == '/')
            return divide(prev, next);
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    public int add(int prev, int next) {
        return prev + next;
    }

    public int subtract(int prev, int next) {
        return prev - next;
    }

    public int multiply(int prev, int next) {
        return prev * next;
    }

    public int divide(int prev, int next) {
        if (next == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return prev / next;
    }

    public void verifyInputValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백입니다.");
        }
    }

}