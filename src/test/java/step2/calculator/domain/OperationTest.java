package step2.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step2.calculator.domain.Operation.ErrorMessage.CAN_NOT_DIVIDE_BY_ZERO;
import static step2.calculator.domain.Operation.ErrorMessage.NOT_FOUND_MATCHED_OPERATION;

class OperationTest {

    @DisplayName("apply")
    @Nested
    class Apply {
        @DisplayName("plus 연산 결과로 정수 반환")
        @Test
        public void plus() {
            // given
            final int x = 1;
            final int y = 2;
            final Operation plusOp = Operation.PLUS;

            // when
            final int result = plusOp.apply(x, y);

            // then
            assertThat(result).isEqualTo(3);
        }

        @DisplayName("minus 연산 결과로 정수 반환")
        @Test
        public void minus() {
            // given
            final int x = 1;
            final int y = 2;
            final Operation minusOp = Operation.MINUS;

            // when
            final int result = minusOp.apply(x, y);

            // then
            assertThat(result).isEqualTo(-1);
        }

        @DisplayName("times 연산 결과로 정수 반환")
        @Test
        public void times() {
            // given
            final int x = 1;
            final int y = 2;
            final Operation timesOp = Operation.TIMES;

            // when
            final int result = timesOp.apply(x, y);

            // then
            assertThat(result).isEqualTo(2);
        }
        
        @DisplayName("divide")
        @Nested
        class Divide {
            @DisplayName("연산 결과로 정수 반환")
            @Test
            public void divide() {
                // given
                final int x = 1;
                final int y = 2;
                final Operation divideOp = Operation.DIVIDE;

                // when
                final int result = divideOp.apply(x, y);

                // then
                assertThat(result).isEqualTo(0);
            }

            @DisplayName("0으로 나누는 연산인 경우 'IllegalArgumentException'을 throw")
            @Test
            public void throw_IllegalArgumentException_when_divide_by_zero() {
                // given
                final int x = 1;
                final int y = 0;
                final Operation divideOp = Operation.DIVIDE;

                // when
                final Throwable thrown = catchThrowable(() -> {
                    divideOp.apply(x, y);
                });

                // then
                assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(CAN_NOT_DIVIDE_BY_ZERO.getMessage());
            }
        }
    }

    @Nested
    @DisplayName("symbolOf")
    class SymbolOf {
        @DisplayName("입력된 문자열에 매칭되는 'Operation'이 존재하는 경우 매칭된 'Operation'을 반환")
        @ParameterizedTest
        @CsvSource(value = {"+:PLUS", "-:MINUS", "*:TIMES", "/:DIVIDE"}, delimiter = ':')
        void return_Operation_when_input_symbol_matched(final String input, final Operation expected) {
            // when
            final Operation result = Operation.symbolOf(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @DisplayName("입력된 문자열에 매칭되는 'Operation'이 없는 경우 'IllegalArgumentException'를 throw")
        @ParameterizedTest
        @ValueSource(strings = {
                "A",
                "홍",
                "&",
                "@",
        })
        void throw_IllegalArgumentException_when_input_symbol_not_matched(final String input) {
            // when
            final Throwable thrown = catchThrowable(() -> {
                Operation.symbolOf(input);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_FOUND_MATCHED_OPERATION.getMessage());
        }
    }

    @DisplayName("getSupportedSymbols 호출 시 지원되는 수식 기호를 리스트로 반환")
    @Test
    void should_return_supportedSymbols() {
        // when
        final List<String> result = Operation.getSupportedSymbols();

        // then
        assertThat(result).isNotEmpty();
    }

}