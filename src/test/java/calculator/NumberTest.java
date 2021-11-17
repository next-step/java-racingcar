package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @Test
    void add() {
        Number result = new Number("3").add(new Number("2"));
        assertThat(result).isEqualTo(new Number("5"));
    }

    @Test
    void subtract() {
        Number result = new Number("3").subtract(new Number("2"));
        assertThat(result).isEqualTo(new Number("1"));
    }

    @Test
    void multiply() {
        Number result = new Number("3").multiply(new Number("2"));
        assertThat(result).isEqualTo(new Number("6"));
    }

    @Test
    void divide() {
        Number result = new Number("6").divide(new Number("2"));
        assertThat(result).isEqualTo(new Number("3"));
    }
}
