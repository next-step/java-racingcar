import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int calculate(String str) {
        String[] splitStr = split(str);
        int[] numbers = parseToInt(splitStr);
        return sum(numbers);
    }

    private String[] split(String str) {
        String pattern = "//(.)\n(.+)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String expression = matcher.group(2);
            if (customDelimiter.matches("[.,\\\\+*?\\[^\\]$(){}=!<>|:-]")) {
                customDelimiter = String.format("\\%s", customDelimiter);
            }
            return expression.split(customDelimiter);
        } else {
           return str.split(",|;");
        }
    }

    private int[] parseToInt(String[] strings) {
        int[] parsedNumbers = new int[strings.length];
        try {
            for (int i = 0; i < strings.length; i++) {
                int parsedNumber = Integer.parseInt(strings[i]);
                if (parsedNumber < 0) {
                    throw new RuntimeException();
                }
                parsedNumbers[i] = parsedNumber;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        return parsedNumbers;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
