import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELEMITER = "[,:]";
    public static final String CUSTOM_DELEMITER_REGEX = "//.*\n";

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        String delemiter = DEFAULT_DELEMITER;

        Pattern pattern = Pattern.compile(CUSTOM_DELEMITER_REGEX);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            delemiter = matcher.group().substring(2, matcher.end() -1);
            input = matcher.replaceAll("");
        }

        String[] split = input.split(delemiter);

        int result = 0;
        for (int i=0; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);

            validatePositive(tmp);
            result += tmp;
        }

        return result;
    }

    private void validatePositive(int number) {
        if (number < ZERO) {
            throw new RuntimeException("음수가 포함되어 있음");
        }
    }
}
