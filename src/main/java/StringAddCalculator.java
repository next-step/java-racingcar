import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String COMMA = ",";
    private static final String DOUBLE_DOT = ":";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty())
            return 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return cacluateSum(tokens);
        }
        String[] numbers = text.split("[" + COMMA + DOUBLE_DOT + "]");
        return cacluateSum(numbers);
    }

    private static int cacluateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            validatePositveNumber(number);
            int parseNum = Integer.parseInt(number);
            if (parseNum < 0) {
                throw new RuntimeException();
            }
            sum += parseNum;
        }
        return sum;
    }

    private static void validatePositveNumber(String number) {
        try {
            int parseNum = Integer.parseInt(number);
            if (parseNum < 0) {
                throw new RuntimeException("음수는 들어올 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 형태가 아닌 값이 존재합니다.");
        }

    }
}
