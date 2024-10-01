package calculator;

public class StringAddCalculator {

    public static final String DELIMITER = ",|:";

    public static int cal(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return stringSum(toInts(getSplit(text)));
    }

    private static String[] getSplit(String text) {
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static int stringSum(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}
