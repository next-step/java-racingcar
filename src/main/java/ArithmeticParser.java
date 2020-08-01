import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArithmeticParser {
    private static final String OPERATOR_PATTERN = "[-*/+]";
    private static final String OPERAND_PATTERN = "[0-9]+";

    private ArithmeticParser() {
    }
    
    public static List<Integer> extractOperandsFromString(String expression) {
        return Stream.of(expression.split(" "))
                .filter(element -> Pattern.matches(OPERAND_PATTERN, element))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Operator> extractOperationsFromString(String expression) {
        return Stream.of(expression.split(" "))
                .filter(element -> Pattern.matches(OPERATOR_PATTERN, element))
                .map(Operator::getOperator)
                .collect(Collectors.toList());
    }
}
