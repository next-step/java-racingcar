package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다")
    void check_empty_string() {
        assertThat(StringAddCalculator.calculate(null)).isEqualTo(0);
        assertThat(StringAddCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void convert_string_to_number() {
        assertThat(StringAddCalculator.calculate("1")).isEqualTo(1);
        assertThat(StringAddCalculator.calculate("123")).isEqualTo(123);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    void split_and_add_numbers() {
        String text = "1,2";
        assertThat(StringAddCalculator.calculate(text)).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    void split_with_colon() {
        String text = "1,2:3";
        assertThat(StringAddCalculator.calculate(text)).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void custom_delimiter() {
        String text = "//!\n1!2!3!";
        assertThat(StringAddCalculator.calculate(text)).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void number_exception() {
        String text = "-1,2,3";
        assertThatThrownBy(() -> StringAddCalculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
