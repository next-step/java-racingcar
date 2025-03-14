import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        if (hasCustomDelimiter(text)) {
            return sum(text.split("[,:]"));
        }
        return parseAndSumWithCustomDelimiter(text);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static Integer parseAndSumWithCustomDelimiter(String text) {
        Matcher m = getCustomDelimeterAndNumbers(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] stringNumbers = m.group(2).split(customDelimiter);
            return sum(stringNumbers);
        }
        throw new RuntimeException("입력을 확인해주세요.");
    }

    private static Matcher getCustomDelimeterAndNumbers(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private static boolean hasCustomDelimiter(String text) {
        return !text.startsWith("//");
    }

    private static int sum(String[] stringNumbers) {
        int sum = 0;
        for (String stringNumber : stringNumbers) {
            int number = parseNumber(stringNumber);
            sum += number;
        }
        return sum;

    }

    private static int parseNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) {
            throw new RuntimeException("음수는 불가능합니다.");
        }
        return number;
    }
}
