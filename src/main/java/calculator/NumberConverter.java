package calculator;

public class NumberConverter {

    private NumberConverter() {
    }

    public static Number from(int value) {
        return new IntegerNumber(value);
    }

    public static Number from(long value) {
        return new IntegerNumber(value);
    }

    public static Number from(double value) {
        return new DecimalNumber(value);
    }

    public static Number from(float value) {
        return new DecimalNumber(value);
    }
}
