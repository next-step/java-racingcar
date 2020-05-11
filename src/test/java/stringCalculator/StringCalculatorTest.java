package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import stringCalculator.exception.CannotBeDividedIntoZeroException;

import static org.assertj.core.api.Assertions.*;

@DisplayName("StringCalculator 클래스 테스트")
public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("input 값이")
    class Describe_input {
        @Test
        @DisplayName("정상일 경우 올바른 연산 결과를 리턴한다.")
        void it_returns_calculated_value() {
            String input = "2 + 3 * 4 / 2";
            int actual = stringCalculator.main(input);

            assertThat(actual).isEqualTo(10);
        }

        @Test
        @DisplayName("공백 문자열일 경우 예외를 리턴한다.")
        void it_returns_exception_with_empty() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                String input = "";
                stringCalculator.main(input);
            }).withMessage("입력 값이 비어 있습니다.");
        }

        @Test
        @DisplayName("null일 경우 예외를 리턴한다.")
        void it_returns_exception_with_null() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                stringCalculator.main(null);
            }).withMessage("입력 값이 비어 있습니다.");
        }

        @Test
        @DisplayName("지원하지 않는 연산자가 포함된 경우 예외를 리턴한다.")
        void it_returns_exception_with_not_supported_operator() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                String input = "2 % 3";
                stringCalculator.main(input);
            }).withMessage("지원 하지 않는 연산자 입니다.");
        }
    }

    @Nested
    @DisplayName("사칙 연산 테스트")
    class Describe_calculate {
        @Test
        @DisplayName("덧셈")
        void it_returns_plus_calculated_value() {
            String input = "2 + 3 + 10";
            int actual = stringCalculator.main(input);

            assertThat(actual).isEqualTo(15);
        }

        @Test
        @DisplayName("뺄셈")
        void it_returns_minus_calculated_value() {
            String input = "10 - 3 - 1";
            int actual = stringCalculator.main(input);

            assertThat(actual).isEqualTo(6);
        }

        @Test
        @DisplayName("곱셈")
        void it_returns_multiply_calculated_value() {
            String input = "10 * 9";
            int actual = stringCalculator.main(input);

            assertThat(actual).isEqualTo(90);
        }

        @Nested
        @DisplayName("나눗셈")
        class Context_divide {
            @Test
            @DisplayName("0으로 나눈 경우")
            void it_returns_divide_exception() {
                assertThatExceptionOfType(CannotBeDividedIntoZeroException.class)
                        .isThrownBy(() -> {
                            String input = "10 / 0";
                            stringCalculator.main(input);
                        }).withMessage("0으로 나눌 수 없습니다.");
            }

            @Test
            @DisplayName("0이 아닌 값으로 나눈 경우")
            void it_returns_divide_calculated_value() {
                String input = "10 / 5";
                int actual = stringCalculator.main(input);

                assertThat(actual).isEqualTo(2);
            }
        }
    }
}
