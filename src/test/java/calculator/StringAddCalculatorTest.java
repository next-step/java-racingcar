package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열이거나 null인경우 숫자합계 반환")
    void splitAndSumWhenBlankOrNull(String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("단일 숫자형 문자열 합계반환")
    void splitAndSumWhenOnlyDigitString() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표를 기준으로 문자열 분리하여 합계 반환")
    void splitAndSumWithComma() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론을 기준으로 문자열 분리하여 합계 반환")
    void splitAndSumWithColon() {
        int result = StringAddCalculator.splitAndSum("2:3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("쉼표와 콜론 기준으로 문자열 분리하여 합계 반환")
    void splitAndSumWithCommaAndColon() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("digit like 문자열 이외의 값 전달하는경우 예외반환")
    void raiseExceptionWhenPassNotDigitString() {
        assertThrows(RuntimeException.class, () ->
                StringAddCalculator.splitAndSum("HelloWorld,123")
        );
    }

    @Test
    @DisplayName("음수 전달하는경우 예외반환")
    void 음수_전달하는경우_예외반환() {
        assertThrows(RuntimeException.class, () ->
                StringAddCalculator.splitAndSum("1,-1")
        );
    }

    @Test
    @DisplayName("커스텀 구분자 기준으로 합계 반환")
    void 커스텀_구분자_기준으로_합계_반환() {
        int result = StringAddCalculator.splitAndSum("//@\n1@5@6");
        assertThat(result).isEqualTo(12);
    }
}
