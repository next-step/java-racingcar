import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    final static Pattern customDelimiterPattern = Pattern.compile("(?<=//)(.*)(?=\\n)", Pattern.MULTILINE);

    final static String defaultDelimiter = ",|:";

    static String[] splitToNumber(String input) {
        String delimiter = getDelimiter(input);
        return input.replace("//" + delimiter + "\n", "").split(delimiter);
    }

    private static String getDelimiter(String str) {
        Matcher matcher = customDelimiterPattern.matcher(str);

        if (matcher.find())
            return matcher.group(0);
        else
            return defaultDelimiter;
    }
}
