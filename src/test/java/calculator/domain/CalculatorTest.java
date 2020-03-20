package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
        BigDecimal result = calculator.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(new BigDecimal(10));

        assertThatThrownBy(() -> calculator.calculate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 혹은 빈 값");
    }

    @Test
    public void apply() {
        BigDecimal result1 = calculator.apply("+", new BigDecimal(1), new BigDecimal(2));
        BigDecimal result2 = calculator.apply("-", new BigDecimal(3), new BigDecimal(1));
        BigDecimal result3 = calculator.apply("*", new BigDecimal(2), new BigDecimal(3));
        BigDecimal result4 = calculator.apply("/", new BigDecimal(10), new BigDecimal(2));

        assertThat(result1).isEqualTo(new BigDecimal(3));
        assertThat(result2).isEqualTo(new BigDecimal(2));
        assertThat(result3).isEqualTo(new BigDecimal(6));
        assertThat(result4).isEqualTo(new BigDecimal(5));

        assertThatThrownBy(() -> calculator.apply("1", new BigDecimal(1), new BigDecimal(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("올바르지 않은 symbol : %s", "1"));
    }
}
