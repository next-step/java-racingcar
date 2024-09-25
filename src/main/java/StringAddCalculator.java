import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final List<String> DEFAULT_SEPARATORS = List.of(",", ":");

    public static int splitAndSum(final String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        final ParsedExpression parsedExpression = buildParsedExpression(expression);
        return parsedExpression.calculate();
    }

    private static ParsedExpression buildParsedExpression(final String expression) {
        final Matcher matcher = Pattern.compile("//(.)\n").matcher(expression);
        final Set<String> separators = new HashSet<>(DEFAULT_SEPARATORS);
        while (matcher.find()) {
            separators.add(matcher.group(1));
        }
        return new ParsedExpression(matcher.replaceAll(""), List.copyOf(separators));
    }

    static class ParsedExpression {
        private final String expression;
        private final List<String> separators;

        public ParsedExpression(final String expression, final List<String> separators) {
            this.expression = expression;
            this.separators = separators;
        }

        public int calculate() {
            if (empty()) {
                return 0;
            }

            final int[] numbers = getNumbers();
            return Arrays.stream(numbers).sum();
        }

        private boolean empty() {
            return expression == null || expression.isEmpty();
        }

        private int[] getNumbers() {
            final String[] calculateTarget = expression.split(String.join("|", separators));
            return Arrays.stream(calculateTarget)
                .mapToInt(Integer::parseUnsignedInt)
                .toArray();
        }
    }
}
