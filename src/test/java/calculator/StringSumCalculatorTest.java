package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSumCalculatorTest {

    @Test
    @DisplayName("Blank 테스트")
    void splitAndSum_nullOrEmpty() {
        assertThat(StringSumCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringSumCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("인풋 1개 테스트")
    void splitAndSum_oneString() {
        assertThat(StringSumCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마 스플릿 테스트")
    void splitAndSum_comma() {
        assertThat(StringSumCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마, 세미콜론 스플릿 테스트")
    void splitAndSum_commaOrSemiColon() {
        assertThat(StringSumCalculator.splitAndSum("1,2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("특수문자 정규식 테스트")
    void splitAndSum_specialCharacters() {
        assertThat(StringSumCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("정수 외 예외처리 테스트")
    void splitAndSum_negativeString() {
        assertThatThrownBy(() ->
            StringSumCalculator.splitAndSumThrows("//;\n1;2;3")
        ).isInstanceOf(RuntimeException.class).hasMessage("Matcher spacial character number");

        assertThatThrownBy(() ->
                StringSumCalculator.splitAndSumThrows("-1,2,3")
        ).isInstanceOf(RuntimeException.class).hasMessage("Contains negative");
    }
}
