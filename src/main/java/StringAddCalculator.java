import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    final static Pattern customDelimiterPattern = Pattern.compile("(?<=//)(.*)(?=\\n)", Pattern.MULTILINE);

    static int splitAndSum(String input) {
        if (input == null || input.isBlank()) return 0;

        int sum = 0;
        String customDelimiter = checkCustomDelimiter(input);
        List<String> splitString = customDelimiter == null ? splitByDefault(input) : splitByCustom(input, customDelimiter);

        for (String value : splitString) {
            sum += Integer.parseUnsignedInt(value);
        }

        return sum;
    }

    static List<String> splitByDefault(String input) {
        List<String> result = new ArrayList();
        String[] splitStringByRest = input.split(",");

        for (String value : splitStringByRest) {
            String[] splitStringByColon = value.split(":");
            result.addAll(Arrays.asList(splitStringByColon));
        }

        return result;
    }

    static List<String> splitByCustom(String input, String delimiter) {
        String inputWithoutDelimiter = input.split("\n")[1];
        return Arrays.asList(inputWithoutDelimiter.split(delimiter));
    }

    static String checkCustomDelimiter(String str) {
        Matcher matcher = customDelimiterPattern.matcher(str);

        if(matcher.find())
            return matcher.group(0);
        else
            return null;
    }
}
