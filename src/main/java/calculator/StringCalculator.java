package calculator;

public class StringCalculator {

    public static int parseAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        return Integer.parseInt(text);
    }
}
