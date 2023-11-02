package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {

    @Nested
    @DisplayName("문자열 splitSum 계산기 성공 케이스")
    class SuccessConditionTest {
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("null 또는 빈문자열 입력시 0을 반환한다.")
        void splitAndSum_null_또는_빈문자열(String inpuString) {
            assertThat(StringAddCalculator.splitAndSum(inpuString)).isEqualTo(0);
        }

        @Test
        @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
        void splitAndSum_숫자하나() {
            String inputString = "1";

            int result = StringAddCalculator.splitAndSum(inputString);

            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("숫자 두개를 컴마(,) 구분자로 입력시 두 숫자의 합을 반환한다.")
        void splitAndSum_숫자두개_컴마() {
            String inputString = "1,2";

            int result = StringAddCalculator.splitAndSum(inputString);

            assertThat(result).isEqualTo(3);
        }

        @Test
        @DisplayName("숫자 두개를 콜론(:) 구분자로 입력시 두 숫자의 합을 반환한다.")
        void splitAndSum_숫자두개_콜론() {
            String inputString = "1:2";

            int result = StringAddCalculator.splitAndSum(inputString);

            assertThat(result).isEqualTo(3);
        }

        @Test
        @DisplayName("숫자 사이에 구분자를 컴마(,)와 콜론(:)을 사용하여도 두 숫자의 합을 반환한다.")
        void splitAndSum_숫자두개이상_구분자두개() {
            String inputString = "1:2,3:4";

            int result = StringAddCalculator.splitAndSum(inputString);

            assertThat(result).isEqualTo(10);
        }

        @Test
        @DisplayName("//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
        void splitAndSum_숫자두개이상_커스텀구분자() {
            String inputString = "//;\n1;2;3";

            int result = StringAddCalculator.splitAndSum(inputString);

            assertThat(result).isEqualTo(6);
        }
    }

    @Nested
    @DisplayName("문자열 splitSum 계산기 성공 케이스")
    class FailConditionTest {

        @Test
        @DisplayName("음수를 전달할 경우 예외가 발생해야 한다.")
        void splitAndSum_negative() {
            assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("양수만 입력 가능합니다.");
        }

        @Test
        @DisplayName("여러개 문자중 문자열 입력을 하지 않았을 경우 예외가 발생해야 한다.")
        void splitAndSum_문자열_없음() {
            assertThatThrownBy(() -> StringAddCalculator.splitAndSum(",2,3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자 양식만 입력 바랍니다.");
        }

        @Test
        @DisplayName("여러개 문자중 정수가 아닌것을 입력했을 경우 예외가 발생해야 한다.")
        void splitAndSum_정수가_아닌문자() {
            assertThatThrownBy(() -> StringAddCalculator.splitAndSum("T,2,3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자 양식만 입력 바랍니다.");
        }
    }
}
