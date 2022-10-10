package util;

import domain.calculator.dto.Positive;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveTest {

    @Test
    public void init() {
        assertThat(new Positive(1)).isNotNull();

        assertThatThrownBy(() -> new Positive(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수값은 허용되지 않습니다.");
    }

    @Test
    public void 덧셈_숫자() {
        Positive numberOne = new Positive(1);
        int numberTwo = 2;

        int expected = 3;

        assertThat(numberOne.plus(numberTwo)).isEqualTo(expected);
    }

    @Test
    public void 덧셈_Positive객체() {
        Positive numberOne = new Positive(1);
        Positive numberTwo = new Positive(2);

        Positive expected = new Positive(3);

        assertThat(numberOne.plus(numberTwo)).isEqualTo(expected);
    }
}