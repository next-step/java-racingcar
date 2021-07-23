package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @Test
    void calc_add(){
        int result = StringCalculator.calc("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void calc_sub(){
        int result = StringCalculator.calc("3 - 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void calc_mul(){
        int result = StringCalculator.calc("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void calc_div(){
        int result = StringCalculator.calc("6 / 2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("입력 값이 null 이거나 공백문자일 경우 에러")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void calc_error_empty(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calc(input);
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 에러")
    @ParameterizedTest
    @ValueSource(strings = {"1 . 1", "1 1 1", "1 1"})
    void calc_error_operator(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calc(input);
        });
    }
}
