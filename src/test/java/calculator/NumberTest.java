package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"-1", "a"})
    @DisplayName("음수나 숫자 이외의 값이 들어오면 예외를 반환한다.")
    void negative_or_except_numbers_throw_error(String input) {
        assertThatThrownBy(() -> new Number(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("여러 숫자를 구분자와 함께 입력하면 숫자의 합을 반환한다.")
    void add_two_number() {
        Number number1 = new Number("1");
        Number number2 = new Number("2");
        assertThat(number1.add(number2)).isEqualTo(new Number("3"));
    }
}
