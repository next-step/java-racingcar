package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PreconditionsTest {
    private static final String ERROR_MESSAGE = "";

    @DisplayName("checkArgument")
    @Nested
    class CheckArgument {
        @DisplayName("'expression'이 'true'인 경우 예외를 throw 안함")
        @Test
        void not_throw_IllegalArgumentException_when_expression_is_true() {
            // given
            final boolean expression = true;

            // when
            final Throwable thrown = catchThrowable(() -> {
                Preconditions.checkArgument(expression, ERROR_MESSAGE);
            });

            // then
            assertThat(thrown).isNull();
        }

        @DisplayName("'expression'이 'false'인 경우 'errorMessage'를 가진 'IllegalArgumentException'를 throw")
        @Test
        void throw_IllegalArgumentException_when_expression_is_false() {
            // given
            final boolean expression = false;

            // when
            final Throwable thrown = catchThrowable(() -> {
                Preconditions.checkArgument(expression, ERROR_MESSAGE);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

}