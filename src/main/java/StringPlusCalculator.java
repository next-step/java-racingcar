import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    protected String getSeperator(String input) {
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public int calculate(String input) {
        String seperator = getSeperator(input);
        String[] splited = input.replaceAll("//(.*?)\n", "")
                                .split("[" + ",:" + seperator + "]");

        return Arrays.stream(splited)
                     .filter(s -> !s.isEmpty())
                     .mapToInt(Integer::parseInt)
                     .sum();
    }

}
