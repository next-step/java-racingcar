package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    public static final String DELIMITER = ",|:";

    private int calcStringWithDel(String text, String delimiter) {
        Stream<String> stream = Arrays.stream(text.split(delimiter));
        return stream
                .mapToInt(Integer::parseInt)
                .peek(this::checkNegativeNum)
                .sum();
    }

    private void checkNegativeNum(int num) {
        if (num < 0) {
            throw new RuntimeException("음수값은 처리할 수 없습니다.");
        }
    }

    public int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String delimiter = DELIMITER;
        String data = text;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            data = m.group(2);
        }
        return calcStringWithDel(data, delimiter);
    }

}
