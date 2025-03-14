package study;

public class Calculator {

    private static final String NUMBERS_DELIMITER_REGEX = "[,:]";

    public static int sum(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        String[] numberStrings = s.split(NUMBERS_DELIMITER_REGEX);
        return sum(numberStrings);
    }

    private static int sum(String[] numberStrings) {
        int sum = 0;
        for (String numberString : numberStrings) {
            sum += Integer.parseInt(numberString);
        }
        return sum;
    }
}
