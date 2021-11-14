package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    private final List<Operator> operators = Arrays.asList(
            Operator.PLUS,
            Operator.TIMES,
            Operator.DIVIDE_BY
    );
    private final List<CalculatorNumber> numbers = Stream.of(1, 2, 3, 1)
            .map(CalculatorNumber::new)
            .collect(Collectors.toList());

    @Test
    public void from() {
        Expression result = Expression.from("1 + 2 * 3 / 1");
        assertThat(result).isEqualTo(new Expression(numbers, operators));
    }

    @Test
    public void compute() {
        CalculatorNumber result = new Expression(numbers, operators).compute();
        assertThat(result).isEqualTo(new CalculatorNumber(9));
    }
}
