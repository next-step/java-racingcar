import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public final static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return sum(split(input));
    }


    public static String[] split(String input) {
        Matcher matcher = pattern.matcher(input);
        String delimiter = ",|:";
        String numbersPart = input;

        if (matcher.matches()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            delimiter += "|" + customDelimiter;
            numbersPart = matcher.group(2);
        }

        return numbersPart.split(delimiter);
    }

    public static int sum(String[] numbers) {
        int sum = 0;
        for (String s : numbers) {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new RuntimeException("numbers는 음수를 허용하지 않습니다.");
            }
            sum += number;
        }
        return sum;
    }
}
