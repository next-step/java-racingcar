package calculator;

public class Calculator {

    public static final String DELIMITER = ",|:";

    public static int cal(String text) {
        if (isBlank(text)) {
            return 0;
        }

        if (text.contains("-")) throw new IllegalArgumentException();

        if (isCustomPattern(text)) {
            return sum(toInts(split(text.substring(text.indexOf("\\n") + 2), retrieveCustomPattern(text))));
        }

        return sum(toInts(split(text)));
    }

    private static String retrieveCustomPattern(String text) {
        return text.substring(text.indexOf("//") + 2, text.indexOf("\\n"));
    }

    private static boolean isCustomPattern(String text) {
        return text.contains("//") && text.contains("\\n");
    }

    private static String[] split(String text, String customGubun) {
        return text.split(DELIMITER + "|" + customGubun);
    }

    private static String[] split(String text) {
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] values) {
        int sum = 0;
        for (int param : values) {
            sum += param;
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
