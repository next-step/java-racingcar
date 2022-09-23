package step2;

public class StringAddCalculator {

    private static final int ZERO = 0;

    public static int splitAndSum(String text) {
        int result = 0;
        if (text == null || text.isBlank()) {
            result = ZERO;
        }
        return result;
    }
}
