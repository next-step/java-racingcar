package step2.calculator.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionSymbolValidatorTest {
    @DisplayName("isValid")
    @Nested
    class IsValid {
        @DisplayName("입력 값이 사칙연산 표현식인 경우 true 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1 + 1",
                "2 - 2",
                "3 * 3",
                "4 / 4",
        })
        void return_true_when_input_is_four_fundamental_arithmetic_operation(final String input) {
            // when
            final boolean result = ExpressionSymbolValidator.isValid(input);

            // then
            assertThat(result).isTrue();
        }

        @DisplayName("입력 값이 사칙연산 표현식이 아닌 경우 false 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1 A 1 + 1",
                "2 B 2 - 2",
                "3 C 3 * 3",
                "4 D 4 / 4",
        })
        void return_false_when_input_is_not_four_fundamental_arithmetic_operation(final String input) {
            // when
            final boolean result = ExpressionSymbolValidator.isValid(input);

            // then
            assertThat(result).isFalse();
        }
    }

    @DisplayName("isInvalid")
    @Nested
    class IsInvalid {
        @DisplayName("입력 값이 사칙연산 표현식 인 경우 false 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1 + 1",
                "2 - 2",
                "3 * 3",
                "4 / 4",
        })
        void return_true_when_input_is_four_fundamental_arithmetic_operation(final String input) {
            // when
            final boolean result = ExpressionSymbolValidator.isInvalid(input);

            // then
            assertThat(result).isFalse();
        }

        @DisplayName("입력 값이 사칙연산 표현식이 아닌 경우 true 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1 A 1 + 1",
                "2 B 2 - 2",
                "3 C 3 * 3",
                "4 D 4 / 4",
        })
        void return_false_when_input_is_not_four_fundamental_arithmetic_operation(final String input) {
            // when
            final boolean result = ExpressionSymbolValidator.isInvalid(input);

            // then
            assertThat(result).isTrue();
        }
    }
}