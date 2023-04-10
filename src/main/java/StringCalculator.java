import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");
    public static final long DEFAULT_RESULT = 0L;

    public static Long sumOfNumbers(String input) {
        if (isNullOrEmpty(input)) return DEFAULT_RESULT;
        var stringCalculatorInput = new StringCalculatorInput(input);
        var delimiters = getAllDelimitersFromCustomDelimiters(stringCalculatorInput.getCustomDelimiters());
        var tokenSplitWithDelimiters = split(stringCalculatorInput.getToken(), delimitersToRegex(delimiters));
        var numbers = parseStringsToLongs(tokenSplitWithDelimiters);
        checkAllNumbersArePositive(numbers);
        return sum(numbers);
    }

    private static List<String> getAllDelimitersFromCustomDelimiters(List<String> customDelimiters) {
        var delimiters = new ArrayList<String>();
        delimiters.addAll(DEFAULT_DELIMITERS);
        delimiters.addAll(customDelimiters);
        return delimiters;
    }

    private static String delimitersToRegex(List<String> delimiters) {
        var regex = new StringBuilder();
        for (var delimiter : delimiters) {
            regex.append(delimiter).append('|');
        }
        deleteLastChar(regex);
        return regex.toString();
    }

    private static void deleteLastChar(StringBuilder stringBuilder) {
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    private static Boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    private static List<String> split(String input, String regex) {
        return List.of(input.split(regex));
    }

    private static List<Long> parseStringsToLongs(List<String> strings) {
        var longs = new ArrayList<Long>();
        for (var element : strings) {
            longs.add(Long.parseLong(element));
        }
        return longs;
    }

    private static void checkAllNumbersArePositive(List<Long> numbers) {
        for (var number : numbers) {
            checkNumberIsPositive(number);
        }
    }

    private static void checkNumberIsPositive(Long number) {
        if (number < 0) {
            throw new RuntimeException("Negative number was given");
        }
    }

    private static Long sum(List<Long> longs) {
        var sum = 0L;
        for (var element : longs) {
            sum += element;
        }
        return sum;
    }
}
