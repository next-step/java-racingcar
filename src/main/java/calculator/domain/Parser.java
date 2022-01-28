package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern NUMBER_OR_OPERATOR_REGEX = Pattern.compile("[+*/-]|[0-9]+");

    public static List<String> parseInput(String userInput) {
        List<String> result = new ArrayList<>();
        Matcher matcher = NUMBER_OR_OPERATOR_REGEX.matcher(userInput);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        Validator.isRightOrder(result);
        return result;
    }
}
