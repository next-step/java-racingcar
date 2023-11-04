package calculator;

public class Calculator {

    public static final String DELIMITER_COMMA = ",";
    public static final String DELIMITER_COLON = ":";
    public static final int NULL_VALUE = 0;

    public static int cal(String text) {
        if (isBlank(text)) {
            return NULL_VALUE;
        } //else문 사용 지양을 위해 Early Return 지향하자

        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        String delimiter = DELIMITER_COMMA + "|" + DELIMITER_COLON;
        return text.split(delimiter);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    } //추상화 레벨을 sum과 같이 맞추기

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

}
