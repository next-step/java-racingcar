package calculator;

public class StringCasting {
    public static final String NEGATIVE_NUMBERS_ERROR_MESSAGE = "음수는 허용하지 않습니다.";

    public static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBERS_ERROR_MESSAGE);
        }
        return number;
    }
}
