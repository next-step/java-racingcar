import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    final static String regex = "(?<=//)(.*)(?=\\n)";

    static int splitAndSum(String str) {
        int sum = 0;

        if (str != null && !str.isBlank()) {
            String customDelimiter = checkCustomDelimiter(str);
            List<String> splitString = customDelimiter == null ? splitByDefault(str) : splitByCustom(str, customDelimiter);

            for (String value : splitString) {
                sum += Integer.parseUnsignedInt(value);
            }
        }

        return sum;
    }

    static List<String> splitByDefault(String str) {
        List<String> result = new ArrayList();
        String[] splitString = str.split(",");

        for (String value : splitString) {
            String[] element = value.split(":");
            result.addAll(Arrays.asList(element));
        }

        return result;
    }

    static List<String> splitByCustom(String str, String delimiter) {
        String target = str.split("\n")[1];
        return Arrays.asList(target.split(delimiter));
    }

    static String checkCustomDelimiter(String str) {
        Matcher matcher = Pattern.compile(regex, Pattern.MULTILINE).matcher(str);

        if(matcher.find())
            return matcher.group(0);
        else
            return null;
    }
}
