package calculator;


public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return ZERO;
        }
        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        if(text.charAt(0) == '\\' && text.charAt(2) == '\n') {
            String splitChar = text.substring(0, 2);
            return text.split(splitChar);
        }
        return text.split(DELIMITER);
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for (int value : numbers) {
            sum += value;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int [] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = toInt(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if(number < 0 ){
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.equals("");
    }
}


