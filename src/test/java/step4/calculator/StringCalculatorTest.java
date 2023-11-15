package step4.calculator;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자열 입력시 0 반환")
    void null_and_empty(String target){
        // when
        int result = StringCalculator.calculate(target);
        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName(", 구분자로 입력할 경우")
    void comma_delimeter() throws Exception {
        // given
        String target = "1,2";

        // when
        int result = StringCalculator.calculate(target);

        // then
        assertThat(result).isEqualTo(3);
    }
    @Test
    @DisplayName("구분자 여러개가 입력된 경우")
    void comma_and_dot_delimeter() {
        // given
        String target = "1,2:3";

        // when
        int result = StringCalculator.calculate(target);

        // then
        assertThat(result).isEqualTo(6);
    }
    @Test
    @DisplayName("구분자 여러개가 입력된 경우")
    void with_custom_delimeter() {
        // given
        String target = "//:\n1:2:3";

        // when
        int result = StringCalculator.calculate(target);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("마이너스가 들어갔을 경우")
    void minus_number_delimeter() {
        // given
        String target = "-1,2,3";

        // when then
        assertThrows(RuntimeException.class,
                () -> StringCalculator.calculate(target)
        );
    }
    @Test
    @DisplayName("숫자 하나를 입력했을 경우")
    void just_one_number() {
        // given
        String target = "1";

        //when
        int result = StringCalculator.calculate(target);

        // then
        assertThat(result).isEqualTo(1);

    }
}
