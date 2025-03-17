import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;
    private  static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return DEFAULT_VALUE;
        }

        if (input.length() == 1){
            return processSingleCharacter(input);
        }

        return processMultipleCharacter(input);
    }

    private static int processSingleCharacter(String input) throws RuntimeException {
        int num;
        try {
            num = Integer.parseInt(input);
            if (num < 0) {
                throw new RuntimeException("Negative number");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Not number value");
        }

        return num;
    }

    private static int processMultipleCharacter(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return addStringNums(tokens);
        }

        return addStringNums(input.split(",|:"));
    }

    private static int addStringNums(String[] tokens) {
        int num = 0;
        for (String numStr : tokens) {
            num += processSingleCharacter(numStr);
        }

        return num;
    }
}
