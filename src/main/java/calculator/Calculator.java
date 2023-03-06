package calculator;

public class Calculator {

    private static final int DEFAULT_VALUE = 0;

    private long result;

    public long getResult() {
        return result;
    }

    Calculator() {
        this(DEFAULT_VALUE);
    }

    Calculator(long number) {
        result = number;
    }

    void addition(long num1, long num2) {
        result = num1 + num2;
    }

    void subtraction(long num1, long num2) {
        result = num1 - num2;
    }

    void multiplication(long num1, long num2) {
        result = num1 * num2;
    }

    void division(long num1, long num2) {
        if(num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        result = num1 / num2;
    }
}
