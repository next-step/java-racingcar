import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String DELIMITERS_REGEX = "[,:]";
    public static final String CUSTOM_DELIMITERS_REGEX = "//(.)\n(.*)";
    private final String text;

    public StringCalculator(String text) {
        this.text = text;
    }

    public int calc() {
        if (isEmptyOrNull(text)) {
            return 0;
        }

        return sum(parseStrsToInts(splitUserInput()));
    }

    private boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }

    private String[] splitUserInput() {
        Matcher m = Pattern.compile(CUSTOM_DELIMITERS_REGEX).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DELIMITERS_REGEX);
    }

    private int[] parseStrsToInts(String[] inputs) {
        int[] result = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            result[i] = parseInt(inputs[i]);
        }
        return result;
    }

    private int parseInt(String input) {
        int parsedNumber = Integer.parseInt(input);

        if (parsedNumber < 0) {
            throw new RuntimeException("negative number is not allowed");
        }
        return parsedNumber;
    }

    private int sum(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
