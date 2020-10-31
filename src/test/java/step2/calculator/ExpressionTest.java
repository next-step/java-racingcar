package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ExpressionTest {

    @Nested
    @DisplayName("생성자")
    class Constructor {
        @DisplayName("입력 값이 null인 경우 IllegalArgumentException throw")
        @Test
        void throw_IllegalArgumentException_when_expression_value_is_null() {
            // given
            final String nullObj = null;

            // when
            final Throwable thrown = catchThrowable(() -> {
                new Expression(nullObj);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Expression's value should not be null");
        }

        @DisplayName("입력 값이 공백 문자인 경우 IllegalArgumentException throw")
        @Test
        void throw_IllegalArgumentException_when_expression_value_is_blank() {
            // given
            final String blank = "";

            // when
            final Throwable thrown = catchThrowable(() -> {
                new Expression(blank);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Expression's value should not be blank");
        }

        @DisplayName("입력 값이 숫자 혹은 사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
        @ParameterizedTest
        @ValueSource(strings = {
                "1 a 1",
                "2 b 2",
                "3 c 3",
                "4 d 4",
                "a b c d e",
                "홍 성 민~~!",
                "      "
        })
        void throw_IllegalArgumentException_when_expression_value_is_not_number_or_operator(final String input) {
            // when
            final Throwable thrown = catchThrowable(() -> {
                new Expression(input);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Expression's value should be consist of number and operations");
        }

        @DisplayName("입력 값이 모두 유효한 경우 Expression_instance 반환")
        @ParameterizedTest
        @ValueSource(strings = {
                "1 + 1",
                "2 - 2",
                "3 * 3",
                "4 / 4",
                "2 + 3 * 4 / 2"
        })
        void return_Expression_instance_if_expression_value_is_valid(final String input) {
            // when
            final Expression result = new Expression(input);

            // then
            assertThat(result).isNotNull();
        }
    }

}