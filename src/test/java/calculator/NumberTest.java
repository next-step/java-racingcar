package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    void create_number() {
        // given
        String input = "1";

        // when
        Number number = new Number(input);

        // expect
        assertThat(number.getValue()).isEqualTo(1);
    }

    @Test
    void create_number_by_integer() {
        // given
        int input = 1;

        // when
        Number number = new Number(input);

        // expect
        assertThat(number.getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("when input is not number, IllegalArgumentException occurs")
    void create_not_with_not_number() {
        // given
        String input = "$";

        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값을 숫자로 변환할 수 없습니다. 입력값 = $");
    }

    @Test
    void plus() {
        // given
        Number number1 = new Number(-1);
        Number number2 = new Number(0);

        assertThat(number1.plus(number2)).isEqualTo(new Number(-1));
    }

    @Test
    void minus() {
        // given
        Number number1 = new Number(2);
        Number number2 = new Number(3);

        assertThat(number1.minus(number2)).isEqualTo(new Number(-1));
    }


    @Test
    void multiply() {
        // given
        Number number1 = new Number(-1);
        Number number2 = new Number(1);

        assertThat(number1.multiply(number2)).isEqualTo(new Number(-1));
    }


    @Test
    void divide() {
        // given
        Number number1 = new Number(-4);
        Number number2 = new Number(3);

        assertThat(number1.divide(number2)).isEqualTo(new Number(-1));
    }


    @Test
    @DisplayName("When divider is 0, throws ArithmeticException")
    void divide_divider_is_zero() {
        // given
        Number number1 = new Number(2);
        Number number2 = new Number(0);

        assertThatThrownBy(() -> number1.divide(number2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0 은 나눗셈을 할 수 없습니다. 다시 입력해주세요.");
    }
}