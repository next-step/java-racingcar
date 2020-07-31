public class StringCalculator {
    private static final String DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다.";

    public String[] split(String input) {
        return input.split(" ");
    }

    public int plus(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    public int minus(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    public int multiply(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }

    public int divide(int firstValue, int secondValue) {
        if (secondValue == 0) {
            throw new IllegalArgumentException(DIVIDE_BY_ZERO);
        }
        return firstValue / secondValue;
    }
}
