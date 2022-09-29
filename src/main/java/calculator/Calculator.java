package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String SEPARATOR = "[,:]";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(getSplit(text)));
    }

    private static String[] getSplit(String text) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(text);
        if (matcher.find()) {
            return getSplitByCustomSeparator(matcher);
        }
        return getSplitByNotCustomSeparator(text);
    }

    private static int[] toInts(String[] split) {
        int[] intArray = new int[split.length];
        putToIntArray(split, intArray);
        return intArray;
    }

    private static void putToIntArray(String[] split, int[] intArray) {
        int parseNumber;
        for (int i = 0; i < intArray.length; i++) {
            parseNumber = getParseNumber(split[i]);
            isNegative(parseNumber);
            intArray[i] = parseNumber;
        }
    }

    private static void isNegative(int parseNumber) {
        if (parseNumber < 0) {
            throw new RuntimeException("음수는 입력할수없습니다");
        }
    }

    private static int getParseNumber(String s) {
        int parseNumber;
        try {
            parseNumber = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자를 입력해주세요 ");
        }
        return parseNumber;
    }

    private static int sum(int[] ints) {
        int sumResult = 0;
        for (int number : ints) {
            sumResult += number;
        }
        return sumResult;
    }

    private static String[] getSplitByNotCustomSeparator(String text) {
        return text.split(SEPARATOR);
    }

    private static String[] getSplitByCustomSeparator(Matcher matcher) {
        String customSeparator = matcher.group(1);
        return matcher.group(2).split(customSeparator);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
