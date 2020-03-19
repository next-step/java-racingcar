package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    public void calculation() {
        int result = calculator.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);

        assertThatThrownBy(() -> calculator.calculate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 혹은 빈 값");
    }

    @Test
    public void apply() {
        int result1 = calculator.apply("+", 1, 2);
        int result2 = calculator.apply("-", 3, 1);
        int result3 = calculator.apply("*", 2, 3);
        int result4 = calculator.apply("/", 10, 2);

        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(6);
        assertThat(result4).isEqualTo(5);

        assertThatThrownBy(() -> calculator.apply("1", 1, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 symbol");
    }
}
