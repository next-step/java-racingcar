package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class SymbolStackTest {
    private static final List<String> PLUS_EXPRESSION_SYMBOLS = Arrays.asList("1", "+", "2");

    @Nested
    @DisplayName("constructor")
    class Constructor {
        @DisplayName("전달 받은 symbol 리스트가 비어 있지 않은 경우")
        @Test
        void return_SymbolStack_instance_if_symbols_not_empty() {
            // when
            final SymbolStack result = new SymbolStack(PLUS_EXPRESSION_SYMBOLS);

            // then
            assertThat(result).isNotNull();
        }

        @DisplayName("전달 받은 symbol 리스트가 비어 있는 경우")
        @Test
        void throw_IllegalArgumentException_if_symbols_empty() {
            // given
            final List<String> emptyList = Collections.emptyList();

            // when
            final Throwable thrown = catchThrowable(() -> {
                new SymbolStack(emptyList);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("symbols should not empty");
        }

        @DisplayName("전달 받은 symbol 리스트의 길이가 3 미만인 경우")
        @Test
        void throw_IllegalArgumentException_if_symbols_size_less_than_three() {
            // given
            final List<String> emptyList = Arrays.asList("1", "+");

            // when
            final Throwable thrown = catchThrowable(() -> {
                new SymbolStack(emptyList);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("symbols should more than 3");
        }
    }

}