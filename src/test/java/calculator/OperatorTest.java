package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {

    Num first = new Num(7);
    Num second = new Num(2);

    @Test
    void addition() {
        assertThat(Operator.of("+").operate(first, second)).isEqualTo(new Num(9));
    }

    @Test
    void subtraction() {
        assertThat(Operator.of("-").operate(first, second)).isEqualTo(new Num(5));
    }

    @Test
    void multiplication() {
        assertThat(Operator.of("*").operate(first, second)).isEqualTo(new Num(14));
    }

    @Test
    void division() {
        assertThat(Operator.of("/").operate(first, second)).isEqualTo(new Num(3));
    }
}
