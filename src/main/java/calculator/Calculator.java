package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String SLASH = "//";
    private static final String LINECHANGE = "\n";
    private static final Pattern COMPILTEDPATTERN = Pattern.compile(SLASH+"(.)"+LINECHANGE+"(.*)");
    private static final int FIRST = 1;
    private static final int SECOND = 2;

    public static int calculate(String text) {
        if (isTextEmpty(text)) {
            return 0;
        }
        if (isContainsCustom(text)) {
            return addText(splitTextByCustomByDelimiter(text));
        }
        if (isContainsDelimiter(text)) {
            return addText(splitText(text));
        }
        return stringToInt(text);
    }

    // text가 빈 문자열인지 확인
    private static boolean isTextEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isContainsDelimiter(String text) {
        return text.contains(COMMA) || text.contains(COLON);
    }

    private static boolean isContainsCustom(String text) {
        return text.contains(SLASH) && text.contains(LINECHANGE);
    }

    private static String[] splitText(String text) {
        return text.split(COMMA+"|"+COLON);
    }

    private static String[] splitTextByCustomByDelimiter(String text) {
        Matcher matcher = findPattern(text);
        if (canFindPattern(matcher)) {
            return findNumbers(matcher).split(findDelimiter(matcher));
        }
        return null;
    }

    private static Matcher findPattern(String text) {
        return COMPILTEDPATTERN.matcher(text);
    }

    private static String findNumbers(Matcher matcher) {
        return matcher.group(SECOND);
    }

    private static String findDelimiter(Matcher matcher) {
        return matcher.group(FIRST);
    }

    private static boolean canFindPattern(Matcher matcher) {
        return matcher.find();
    }

    private static int stringToInt(String text) {
        int value = Integer.parseInt(text);
        if (value < 0) {
            throw new RuntimeException();
        }
        return value;
    }

    private static int addText(String[] splitted) {
        int sum = 0;
        for (int token : stringArrayToIntArray(splitted)) {
            sum += token;
        }
        return sum;
    }

    private static int[] stringArrayToIntArray(String [] results) {
        int[] intArray = new int[results.length];
        for (int i=0; i<intArray.length; i++) {
            intArray[i] = stringToInt(results[i]);
        }
        return intArray;
    }
}
