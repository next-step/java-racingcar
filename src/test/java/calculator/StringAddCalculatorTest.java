package calculator;

import static calculator.StringAddCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 입력할 경우 0을 반환")
    @ParameterizedTest(name = "{index} ==> splitAndSum({0}) return 0.")
    @NullAndEmptySource
    void 빈문자열_null(String testParameter) {
        assertThat(splitAndSum(testParameter)).isZero();
    }

    @Nested
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    class SingleNumberStringCase {

        @Test
        @DisplayName("문자열 '1'를 입력하면 숫자 1를 반환")
        void 문자열1() {
            assertThat(splitAndSum("1")).isEqualTo(1);
        }

        @Test
        @DisplayName("문자열 '9'를 입력하면 숫자 9를 반환")
        void 문자열9() {
            assertThat(splitAndSum("9")).isEqualTo(9);
        }

    }

    @Nested
    @DisplayName("숫자 두 개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    class TwoNumberStringWithCommaCase {

        @Test
        @DisplayName("문자열 '1,2'를 입력하면 숫자 3을 반환")
        void 콤마로_구분된_문자열_1_2() {
            assertThat(splitAndSum("1,2")).isEqualTo(3);
        }

        @Test
        @DisplayName("문자열 '9,10'를 입력하면 숫자 3을 반환")
        void 콤마로_구분된_문자열_9_10() {
            assertThat(splitAndSum("9,10")).isEqualTo(19);
        }
    }

    @Test
    @DisplayName("구분자 컴마(,) 외에 콜론(:) 사용 가능")
    void 구분자_콤마_콜론() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정 가능")
    void 커스텀_구분자_세미콜론_지정() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외 발생")
    void 음수를_전달하면_예외발생() {
        assertThatThrownBy(() -> {
            splitAndSum("-1,2,3");
        })
            .isInstanceOf(RuntimeException.class)
            .hasMessage("음수가 포함되어 있습니다.");
    }

}
