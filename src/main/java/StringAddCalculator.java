import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final Pattern CUSTOM_DELIMITER_EXTRACT_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) throws RuntimeException {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = CUSTOM_DELIMITER_EXTRACT_PATTERN.matcher(text);
        if (matcher.find()){
            delimiter = matcher.group(1);
            text = matcher.group(2);
        }

        return splitAndSum(text, delimiter);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int splitAndSum(String text, String delimiter) {
        int result = 0;
        for (String token : text.split(delimiter)){
            int number = Integer.parseInt(token);
            if (number < 0){
                throw new IllegalArgumentException("input has negative value: " + number);
            }
            result += number;
        }
        return result;
    }

}
