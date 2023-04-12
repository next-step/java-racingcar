package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈문자열 또는 null 값 체크")
    void splitAndSum_null_또는_빈문자(String input) {
        assertThat(splitAndSum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력시 해당숫자 반환")
    void splitAndSum_숫자하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표(,)로 구분한 경우 : 두 숫자의 합 반환")
    void splitAndSum_쉼표구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분한 경우 : 숫자의 합 반환")
    void splitAndSum_custom_구분자() {
        assertThat(splitAndSum("//;\n1;2;3;")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달하는 경우 :  RuntimeException")
    void splitAndSum_음수() {
        assertThatThrownBy(() ->
                splitAndSum("-1,2:3"))
                .isInstanceOf(RuntimeException.class);

        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

}
