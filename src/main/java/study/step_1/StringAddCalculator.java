package study.step_1;

public class StringAddCalculator {

    private static final char DELIMITER_COMMA = ',';
    private static final char DELIMITER_COLON = ':';

    public int splitAndSum(String str) {
        int sumValue = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != DELIMITER_COMMA && str.charAt(i) != DELIMITER_COLON) {
                sumValue += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return sumValue;
    }
}
