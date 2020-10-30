
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {
    private final Operands operands;
    private final Operators operators;

    public Expression(String input) {
        validateInput(input);

        String[] splits = input.split(" ");
        List<String> operandStrs = getOpStrs(splits, Utils::isEven);
        List<String> operatorStrs = getOpStrs(splits, Utils::isOdd);

        this.operands = new Operands(operandStrs);
        this.operators = new Operators(operatorStrs);
    }

    public SimpleExpression extractSimpleExpression() {
        Pair<Integer> p = new Pair<>(this.operands.poll(), this.operands.poll());
        Operator operator = this.operators.poll();

        return new SimpleExpression(p, operator);
    }

    private void validateInput(String input) {
        checkIsNull(input);
        checkIsBlank(input);
    }

    private void checkIsBlank(String input) {
        if (input.replace(" ", "").isEmpty())
            throw new IllegalArgumentException("input string: blank");
    }

    private void checkIsNull(String input) {
        if (input == null)
            throw new IllegalArgumentException("input string: null");
    }

    private List<String> getOpStrs(String[] splits, IntPredicate discriminator) {
        return IntStream.range(0, splits.length)
                .filter(discriminator)
                .mapToObj(i -> splits[i])
                .collect(Collectors.toList());
    }
}
