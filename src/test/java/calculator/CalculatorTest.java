package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {


    @ParameterizedTest
    @ValueSource(strings = {"1"})
    @DisplayName("숫자하나인 경우 그 숫자만 나오게")
    void 숫자_하나(String input) {
        assertThat(splitAndSum(input)).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    @DisplayName("여러숫자인 경우 합한 값이 나오게")
    void 숫자_여러개(String input) {
        assertThat(splitAndSum(input)).isEqualTo(6);
    }

    @Test
    @DisplayName("빈문자열 또는 null인 경우")
    void null_빈문자열_값() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("//와 \n 사이에 있는 값으로 구분자 사용")
    void 커스텀_구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("- 및 숫자 이외의 값 입력 오류 발생")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> splitAndSum("1,ㅁ,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
