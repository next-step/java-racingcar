package step2.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;;

class OperationValidatorTest {
    @DisplayName("isValid")
    @Nested
    class IsValid {
        @DisplayName("입력 값이 사칙연산 기호인 경우 true 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "+",
                "-",
                "*",
                "/",
        })
        void return_true_when_input_is_operation_symbol(final String input) {
            // when
            final boolean result = OperationValidator.isValid(input);

            // then
            assertThat(result).isTrue();
        }

        @DisplayName("입력 값이 사칙연산 기호가 아닌 경우 false 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "A",
                "****",
                "1",
                "0.0111",
        })
        void return_false_when_input_is_not_operation_symbol(final String input) {
            // when
            final boolean result = OperationValidator.isValid(input);

            // then
            assertThat(result).isFalse();
        }
    }

    @DisplayName("isInvalid")
    @Nested
    class IsInvalid {
        @DisplayName("입력 값이 사칙연산 기호인 경우 false 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "+",
                "-",
                "*",
                "/",
        })
        void return_true_when_input_is_operation_symbol(final String input) {
            // when
            final boolean result = OperationValidator.isInvalid(input);

            // then
            assertThat(result).isFalse();
        }

        @DisplayName("입력 값이 사칙연산 기호가 아닌 경우 true 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "A",
                "****",
                "1",
                "0.0111",
        })
        void return_false_when_input_is_not_operation_symbol(final String input) {
            // when
            final boolean result = OperationValidator.isInvalid(input);

            // then
            assertThat(result).isTrue();
        }
    }
}