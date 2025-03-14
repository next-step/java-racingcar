import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String REGEX = ",|:";
    public static final String CUSTOM_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(toInts(split(input)));
    }

    public static Boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    public static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }

        return text.split(REGEX);
    }

    public static int[] toInts(String[] str) {
        int[] numbers = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            numbers[i] = toInt(str[i]);
        }

        return numbers;
    }

    private static int toInt(String s) {
        int num = Integer.parseInt(s);
        if (num < 0) {
            throw new RuntimeException("음수를 허용하지 않습니다.");
        }
        return num;
    }

}
