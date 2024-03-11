import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int calculate(String text) {
        if (isTextEmpty(text)) {
            return 0;
        }
        if (isContainsSlash(text)) {
            return addText(splitTextByCustomByDelimiter(text));
        }
        if (isContainsCommaOrColon(text)) {
            return addText(splitText(text));
        }
        return stringToInt(text);
    }

    // text가 빈 문자열인지 확인
    private static boolean isTextEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isContainsCommaOrColon(String text) {
        return text.contains(",") || text.contains(":");
    }

    private static boolean isContainsSlash(String text) {
        return text.contains("/") && text.contains("\n");
    }

    private static String[] splitText(String text) {
        return text.split(",|:");
    }

    private static String[] splitTextByCustomByDelimiter(String text) {
        Matcher m = findPattern(text);
        if (canFindPattern(m)) {
            return findNumbers(m).split(findDelimiter(m));
        }
        return null;
    }

    private static Matcher findPattern(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private static String findNumbers(Matcher matcher) {
        return matcher.group(2);
    }

    private static String findDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    private static boolean canFindPattern(Matcher matcher) {
        return matcher.find();
    }

    private static int stringToInt(String text) {
        return Integer.parseInt(text);
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
