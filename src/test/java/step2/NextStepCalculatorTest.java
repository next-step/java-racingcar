package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.calculator.Expression;
import step2.calculator.Operation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

class NextStepCalculatorTest {

    @DisplayName("사칙연산 수식을 문자열로 입력한 경우 정수를 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10",
            "1 + 1:2",
            "2 - 2:0",
            "3 * 3:9",
            "4 / 3:1",
            "4 / 5:0",
    }, delimiter = ':')
    void calculate_return_integer(final String input, final Integer expected) {
        // given
        final NextStepCalculator calculator = new NextStepCalculator();

        // when
        int result = calculator.calculate(new Expression(input));

        // then
        assertThat(result).isEqualTo(expected);
    }

    public static class NextStepCalculator {
        // 모든 연산은 x, y, operation symbol 이 필요함. ex) x + y
        private static final int OPERABLE_MINIMUM_SIZE = 3;

        public int calculate(final Expression ex) {
            final SymbolStack symbolStack = new SymbolStack(ex.getSymbols());

            while (isOperable(symbolStack)) {
                final int x = symbolStack.popToInt();
                final Operation op = symbolStack.popToOperation();
                final int y = symbolStack.popToInt();

                final int result = op.apply(x, y);
                
                saveResult(symbolStack, result);
            }

            return symbolStack.popToInt();
        }

        private void saveResult(final SymbolStack symbolStack, final int result) {
            // 중간 결과를 다시 스택에 저장
            symbolStack.add(result);
        }

        private boolean isOperable(final SymbolStack symbolStack) {
            return symbolStack.size() >= OPERABLE_MINIMUM_SIZE;
        }
    }

    public static class SymbolStack {
        final Stack<String> stack;

        public SymbolStack(final List<String> symbols) {
            this.stack = toStack(symbols);
        }

        private Stack<String> toStack(final List<String> symbols) {
            final Iterator<String> reverseIterator = new LinkedList<>(symbols)
                    .descendingIterator();

            return StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(reverseIterator, Spliterator.ORDERED),
                    false)
                    .collect(Collectors.toCollection(Stack::new));
        }

        public Operation popToOperation() {
            return Operation.symbolOf(stack.pop());
        }

        public Integer popToInt() {
            return Integer.parseInt(stack.pop());
        }

        public void add(final Integer number) {
            stack.add(String.valueOf(number));
        }

        public int size() {
            return stack.size();
        }
    }
}