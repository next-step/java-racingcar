package calculator;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    private static StringSumCalculator INSTANCE = null;
    private final Logger logger = Logger.getLogger("logger");

    public final String DEFAULT_DELIMITER = "[,:]";
    public final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
    public final int DELIMITER_GROUP = 1;
    public final int TEXT_GROUP = 2;

    private StringSumCalculator() {

    }

    public static StringSumCalculator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StringSumCalculator();
        }
        return INSTANCE;
    }

    public int sum(final String text) {
        if (isBlank(text)) {
            return 0;
        }
        String[] split = getSplit(text);
        int[] numbers = getNumbers(split);
        return sumNumbers(numbers);
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private int[] getNumbers(final String[] split) {
        final int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            final int number = getPositiveNumber(split[i]);
            result[i] = number;
        }
        return result;
    }

    private int getPositiveNumber(final String split) {
        int number;
        try {
            number = Integer.parseInt(split);
        } catch (NumberFormatException e) {
            logger.severe("숫자 형식이 올바르지 않습니다.");
            throw new RuntimeException();
        }
        if (number < 0) {
            logger.severe("숫자는 음수일 수 없습니다.");
            throw new RuntimeException();
        }
        return number;
    }

    private int sumNumbers(final int[] split) {
        int result = 0;
        for (int number : split) {
            result += number;
        }
        return result;
    }

    private String[] getSplit(final String text) {
        String[] split = text.split(DEFAULT_DELIMITER);
        final Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(DELIMITER_GROUP);
            split = matcher.group(TEXT_GROUP).split(customDelimiter);
        }
        return split;
    }

}
