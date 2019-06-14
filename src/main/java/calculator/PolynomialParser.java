package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class PolynomialParser {

    private static final String REGULAR_EXPRESSION_FOR_POLYNOMIAL = "^(\\d+)(\\s[+\\-*/]\\s\\d+)+$";
    private static final String REGULAR_EXPRESSION_FOR_OPERAND = "\\d+";
    private static final String REGULAR_EXPRESSION_FOR_OPERATOR = "[+\\-*/]";

    static boolean isValid(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("수식이 비어있습니다.");
        }

        Pattern pattern = Pattern.compile(REGULAR_EXPRESSION_FOR_POLYNOMIAL);
        Matcher matcher = pattern.matcher(expression);

        return matcher.matches();
    }

    static List<Integer> extractOperands(String expression) {
        List<String> matches = extractMatches(REGULAR_EXPRESSION_FOR_OPERAND, expression);

        return matches.stream()
                .mapToInt(m -> Integer.parseInt(m))
                .boxed()
                .collect(Collectors.toList());
    }


    static List<String> extractOperators(String expression) {
        return extractMatches(REGULAR_EXPRESSION_FOR_OPERATOR, expression);
    }

    private static List<String> extractMatches(String regularExpression, String expression) {
        if (!isValid(expression)) {
            throw new IllegalArgumentException("수식이 올바르지 않습니다.");
        }

        List<String> matches = new ArrayList<>();

        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        return matches;
    }
}
