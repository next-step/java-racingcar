package calculator;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String[] SEPERATORS = {",", ":"};
    private static final String CUSTOM_SEPERATOR_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        if (Pattern.matches(CUSTOM_SEPERATOR_PATTERN, value)) {
            String customSeperator = value.split("\n")[0].substring(2);
            List<String> tokens = Arrays.asList(value.split("\n")[1].split(customSeperator));

            return sum(tokens);
        }

        List<String> commaTokens = Arrays.asList(value.split(SEPERATORS[0]));
        List<String> colonTokens = new ArrayList<>();
        for (String token : commaTokens) {
            colonTokens.addAll(Arrays.asList(token.split(SEPERATORS[1])));
        }

        return sum(colonTokens);
    }

    private static int sum(List<String> value) {
        int result = 0;
        for (String token : value) {
            int parsed;
            try {
                parsed = parseInt(token);
            } catch (NumberFormatException e) {
                throw new RuntimeException("허용되지 않는 값이 존재합니다.");
            }

            if (parsed < 0) {
                throw new RuntimeException("허용되지 않는 값이 존재합니다.");
            }

            result += parsed;
        }

        return result;
    }
}
