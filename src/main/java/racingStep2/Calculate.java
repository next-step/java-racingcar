package racingStep2;

public class Calculate {

    private Calculate() {}

    public static int add(int value1, int value2) {
        return value1 + value2;
    }

    public static int subtract(int value1, int value2) {
        return value1 - value2;
    }

    public static int multiply(int value1, int value2) {
        return value1 * value2;
    }

    public static int divide(int value1, int value2) {
        Validation.validDivide(value1, value2);
        return value1 / value2;
    }

}
