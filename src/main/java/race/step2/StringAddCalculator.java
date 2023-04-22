package race.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    public static final String DELIMITER = ",|:";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private int calcStringWithDel(String text, String delimiter) {
        Stream<String> stream = Arrays.stream(text.split(delimiter));
        return stream
                .mapToInt(Integer::parseInt)
                .peek(this::checkNegativeNum)
                .sum();
    }

    private void checkNegativeNum(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수값은 처리할 수 없습니다.");
        }
    }

    public int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String delimiter = DELIMITER;
        String data = text;
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            data = matcher.group(2);
        }
        return calcStringWithDel(data, delimiter);
    }

}
