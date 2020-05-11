package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("StringCalculator 클래스 테스트")
public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("input 값이")
    class Describe_calculateMovieFee {
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
}
