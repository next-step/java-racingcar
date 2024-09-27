package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator {
    private static final int DELIMITER = 1;
    private static final int EXPRESSION = 2;
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);


    public static int splitAndSum(String sentence) {
        return sum(toIntArray(split(check(sentence))));
    }

    public static String[] split(String sentence) {
        Matcher m = CUSTOM_PATTERN.matcher(sentence);
        if (m.find()) {
            String delimiter = m.group(DELIMITER);
            String expression = m.group(EXPRESSION);
            return expression.split(delimiter);
        }

        return sentence.split(DEFAULT_DELIMITER);
    }

    public static int[] toIntArray(String[] sentences) {
        int[] numbers = new int[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            numbers[i] = toInt(sentences[i]);
        }

        return numbers;
    }

    public static int toInt(String sentence) {
        int number = Integer.parseInt(sentence);
        if (number < 0) {
            throw new RuntimeException("정수만 입력해주세요.");
        }

        return number;
    }

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static String check(String sentence) {
        if (sentence == null || sentence.isEmpty()) return "0";

        return sentence;
    }
}
