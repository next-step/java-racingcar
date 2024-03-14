package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.calculate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @DisplayName("음수나 숫자가 아니면 에러")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "1#2#3"})
    void exception_test(String elements) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            calculate("-1");
        });
    }

    @Test
    @DisplayName("새로운 덧셈 연산자 지정")
    void sum_with_new_additor() {
        assertThat(calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론으로도 구분자로 사용가능")
    void sum_with_colon() {
        assertThat(calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("컴마로 구분된 숫자 두개")
    void two_num_with_comma() {
        assertThat(calculate("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("문자 하나")
    void single_text() {
        assertThat(calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("Null 값 빈문자")
    void null_value() {
        assertAll(
                ()->assertEquals(calculate(null),0),
                ()->assertEquals(calculate(""),0)
        );    }
}
