import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private final List<Operand> operands;

    public Expression(String input) {
        String[] splits = input.split(" ");
        operands = Arrays.stream(splits)
                .map((split) -> new Operand(split))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return operands.stream().map(Operand::toString).collect(Collectors.joining(" "));
    }
}
