package string;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        return Integer.parseInt(text);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

}
