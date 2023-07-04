package caculator;

import caculator.delimiter.DelimiterResolver;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class Calculator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("(^[\\d]*$)");
    private static final String NEGATIVE_PREFIX = "-";

    private Calculator() {
    }

    public static int sum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        String[] resolved = DelimiterResolver.resolve(text);
        String[] values = resolved[1].split(resolved[0]);
        if (!validate(values)) {
            throw new RuntimeException();
        }

        return Arrays.stream(values)
                     .mapToInt(Integer::parseInt)
                     .reduce(Integer::sum)
                     .orElseThrow(RuntimeException::new);
    }

    private static boolean validate(String[] values) {
        return Arrays.stream(values)
                     .filter(
                             orPredicates(
                                     String::isBlank,
                                     Predicate.not(Calculator::isNumber),
                                     value -> value.startsWith(NEGATIVE_PREFIX)
                             )
                     )
                     .findAny()
                     .isEmpty();
    }

    @SafeVarargs
    private static Predicate<String> orPredicates(Predicate<String>... predicates) {
        return Arrays.stream(predicates)
                     .reduce(x -> false, Predicate::or);
    }

    private static boolean isNumber(String value) {
        return NUMBER_PATTERN.matcher(value).find();
    }

}
