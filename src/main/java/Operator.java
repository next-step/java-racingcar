public class Operator {
    public static int plus(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    public static int minus(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    public static int multiply(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }

    public static int divide(int firstValue, int secondValue) {
        if (secondValue == 0) {
            throw new IllegalArgumentException(ExceptionMessage.DIVIDE_BY_ZERO);
        }
        return firstValue / secondValue;
    }
}
