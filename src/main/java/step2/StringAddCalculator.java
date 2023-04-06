package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    private int calcStringWithDel(String text, String del) {
        Stream<String> stream = Arrays.stream(text.split(del));
        int result = stream
                .mapToInt(Integer::parseInt)
                .peek(this::checkNegativeNum)
                .sum();
        return result;
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
        String del = ",|:";
        String data = text;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            del = m.group(1);
            data = m.group(2);
        }
        return calcStringWithDel(data, del);
    }

}
