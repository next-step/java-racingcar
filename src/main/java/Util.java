import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static final String customDelimiterPattern = "//(.)\\n(.*)";
    private static final String defaultDelimiter = ",|:";
    public static boolean isNullOrBlank(String input) {
        return  input == null || input.isEmpty();
    }

    public static int convertInput(String input) throws RuntimeException {
        return Integer.parseInt(input);
    }

    public static String[] split(String input) {
        return input.split(defaultDelimiter);
    }

    private static String[] split(String input, String customDelimiter) {
        return input.split(customDelimiter);
    }

    public static boolean hasCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(customDelimiterPattern).matcher(input);
        return matcher.find();
    }

    public static String[] splitCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(customDelimiterPattern).matcher(input);
        if(matcher.find()) {
            return split(matcher.group(2), matcher.group(1));
        }
        return new String[0];
    }

    public static void hasMinusNumber(String[] nums)  {
        Long minusNumCount = Arrays.stream(nums).filter(p -> convertInput(p) < 0).count();
        if (minusNumCount > 0) {
            throw new RuntimeException();
        }
    }

}
