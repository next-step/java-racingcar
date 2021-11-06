package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void plus() {
        Number number1 = new Number(1);
        Number number2 = new Number(0);

        assertThat(Operator.PLUS.execute(number1, number2)).isEqualTo(new Number(1));
    }


    @Test
    void minus() {
        Number number1 = new Number(-1);
        Number number2 = new Number(0);

        assertThat(Operator.MINUS.execute(number1, number2)).isEqualTo(new Number(-1));
    }

    @Test
    void multiply() {
        Number number1 = new Number(1);
        Number number2 = new Number(0);

        assertThat(Operator.MULTIPLY.execute(number1, number2)).isEqualTo(new Number(0));
    }

    @Test
    void divide() {
        Number number1 = new Number(1);
        Number number2 = new Number(1);

        assertThat(Operator.DIVIDE.execute(number1, number2)).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("When divider is 0, throws ArithmeticException")
    void divide_divider_is_zero() {
        Number number1 = new Number(1);
        Number number2 = new Number(0);

        assertThatThrownBy(() -> number1.divide(number2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0 은 나눗셈을 할 수 없습니다. 다시 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("When the operator with input value is exist, return true")
    @ValueSource(strings = {
            "+", "-", "*", "/"
    })
    void contains_operator(String inputOperator) {
        assertThat(Operator.contains(inputOperator)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("When the operator with input value is not exist, return false")
    @ValueSource(strings = {
            "$", "^", "34", "",
            " ", "@", "#", "abc"
    })
    void contains_no_operator(String inputOperator) {
        assertThat(Operator.contains(inputOperator)).isFalse();
    }

    @Test
    @DisplayName("When try to create operator with not valid string, returns null")
    void create_no_operator() {
        String notOperator = "$";
        assertThat(Operator.of(notOperator)).isEqualTo(null);
    }
}