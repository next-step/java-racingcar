package step2.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class SymbolStackTest {
    private static final String PLUS_EXPRESSION = "1 + 2";

    @Nested
    @DisplayName("constructor")
    class Constructor {
        @DisplayName("전달 받은 'Expression'의 symbol 리스트가  비어 있지 않은 경우")
        @Test
        void return_SymbolStack_instance_if_symbols_not_empty() {
            // given
            final Expression expression = new Expression(PLUS_EXPRESSION);

            // when
            final SymbolStack result = new SymbolStack(expression);

            // then
            assertThat(result).isNotNull();
        }

        @DisplayName("전달 받은 symbol 리스트의 길이가 3 미만인 경우")
        @Test
        void throw_IllegalArgumentException_if_symbols_size_less_than_three() {
            // given
            final Expression expression = new Expression("1 +");

            // when
            final Throwable thrown = catchThrowable(() -> {
                new SymbolStack(expression);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("symbols should more than 3");
        }
    }

}