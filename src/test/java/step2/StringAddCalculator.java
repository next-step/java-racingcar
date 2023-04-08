package step2;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if(isBoolean(text)) return ZERO;
        return getSum(toInts(getSplit(text)));
    }

    private static String[] getSplit(String text) {
        return text.split(DELIMITER);
    }

    private static boolean isBoolean(String text) {
        return text == null || text.isBlank();
    }

    private static int getSum(int[] numbers) {
        int result = ZERO;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toInts(String[] splitText) {
        int[] numbers = new int[splitText.length];
        for (int i = 0; i < numbers.length; i++) {
            int number = toPositiveNumber(splitText[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toPositiveNumber(String splitText) {
        int number = Integer.parseInt(splitText);
        if(number < 0){throw new RuntimeException("음수는 입력할 수 없습니다");}
        return number;
    }
}
