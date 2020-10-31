package step2.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerValidatorTest {

    @DisplayName("isValid")
    @Nested
    class IsValid {
        @DisplayName("입력 값이 정수인 경우 true 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1",
                "2",
                "1000",
                Integer.MAX_VALUE + "",
        })
        void return_true_when_input_is_number(final String input) {
            // when
            final boolean result = IntegerValidator.isValid(input);

            // then
            assertThat(result).isTrue();
        }

        @DisplayName("입력 값이 정수가 아닌 경우 false 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1 ",
                "abc",
                "홍성민",
                "0.0111",
        })
        void return_false_when_input_is_not_integers(final String input) {
            // when
            final boolean result = IntegerValidator.isValid(input);

            // then
            assertThat(result).isFalse();
        }
    }

    @DisplayName("isInvalid")
    @Nested
    class IsInvalid {
        @DisplayName("입력 값이 정수인 경우 false 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1",
                "2",
                "1000",
                Integer.MAX_VALUE + "",
        })
        void return_true_when_input_is_number(final String input) {
            // when
            final boolean result = IntegerValidator.isInvalid(input);

            // then
            assertThat(result).isFalse();
        }

        @DisplayName("입력 값이 정수가 아닌 경우 true 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1 ",
                "abc",
                "홍성민",
                "0.0111",
        })
        void return_false_when_input_is_not_integers(final String input) {
            // when
            final boolean result = IntegerValidator.isInvalid(input);

            // then
            assertThat(result).isTrue();
        }
    }
}
