package string;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        return 1;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

}
