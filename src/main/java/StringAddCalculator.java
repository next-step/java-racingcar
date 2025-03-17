import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String CHAR_SLASH = "//";
    public static final String CHAR_LINE_BREAK = "\\n";
    public static final String REGEX_DELIMITER = "[,:]";

    public static Integer calculate(String text) {
        if (isInvalid(text)) {
            return 0;
        }

        Integer[] integers = toIntegers(splitText(text));
        for (Integer integer : integers) {
            validateInteger(integer);
        }

        return sum(integers);
    }

    private static void validateInteger(Integer integer) {
        if (integer < 0) {
            throw new RuntimeException();
        }
    }

    private static boolean isInvalid(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(Integer[] integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }

    private static Integer[] toIntegers(String[] strings) {
        Integer[] integers = new Integer[strings.length];

        for (int i = 0; i< strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }

        return integers;
    }

    private static String[] splitText(String text) {
        String customDelimiter = extractCustomDelimiter(text);
        if (customDelimiter != null) {
            text = text.replaceAll(CHAR_SLASH + customDelimiter + CHAR_LINE_BREAK, "");
            return text.split(customDelimiter);
        }
        return text.split(REGEX_DELIMITER);
    }

    private static String extractCustomDelimiter(String text) {
        Pattern pattern = Pattern.compile(CHAR_SLASH + "(.)" + CHAR_LINE_BREAK);
        Matcher matcher = pattern.matcher(text);

        return matcher.find() ? matcher.group(1) : null;
    }
}
