package stringaddcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveIntegerTest {

    @Nested
    @DisplayName("PositiveInteger 생성에 대한 성공 케이스 테스트")
    class SuccessConditionTest {

        @Test
        @DisplayName("숫자하나에 대한 정상 생성을 확인한다.")
        void parsePositiveInteger_숫자하나() {
            String inputString = "1";

            PositiveInteger positiveInteger = PositiveInteger.of(inputString);

            assertThat(positiveInteger.getNumber()).isEqualTo(1);
        }

        @Test
        @DisplayName("숫자두개에 대한 정상 생성을 확인한다.")
        void parsePositiveInteger_숫자두개() {
            String inputString = "12";

            PositiveInteger positiveInteger = PositiveInteger.of(inputString);

            assertThat(positiveInteger.getNumber()).isEqualTo(12);
        }
    }

    @Nested
    @DisplayName("PositiveInteger 생성에 대한 실패 케이스 테스트")
    class FailConditionTest {

        @Test
        @DisplayName("빈 공란을 입력했을 경우 생성에 실패한다.")
        void parsePositiveInteger_공백입력() {
            String inputString = " ";

            assertThatThrownBy(() -> PositiveInteger.of(inputString))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자 양식만 입력 바랍니다.");
        }

        @Test
        @DisplayName("한글을 입력했을 경우 생성에 실패한다.")
        void parsePositiveInteger_한글입력() {
            String inputString = "가";

            assertThatThrownBy(() -> PositiveInteger.of(inputString))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자 양식만 입력 바랍니다.");
        }

        @Test
        @DisplayName("음수를 입력했을 경우 생성에 실패한다.")
        void parsePositiveInteger_음수입력() {
            String inputString = "-1";

            assertThatThrownBy(() -> PositiveInteger.of(inputString))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("양수만 입력 가능합니다.");
        }
    }



}