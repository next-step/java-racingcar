package step1.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProcessUnitTest {
    @ParameterizedTest
    @MethodSource("integerUnits")
    void success_calculate_normal_input(Queue<Integer> operands, Queue<Operators<Integer>> operators) {
        ProcessUnit sut = new ProcessUnit(operands, operators);
        assertThat(sut.operate()).isEqualTo((10 - 10 + 20) / 20 * 30);
    }

    @ParameterizedTest
    @MethodSource("unhandledOperandExistIntegerUnits")
    void fail_calculate_normal_input(Queue<Integer> operands, Queue<Operators<Integer>> operators) {
        ProcessUnit sut = new ProcessUnit(operands, operators);
        assertThatThrownBy(sut::operate).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> integerUnits() {
        Queue<Integer> operands = new LinkedList<>(Arrays.asList(10, 10, 20, 20, 30));
        Queue<Operators<Integer>> operators = new LinkedList<>(Arrays.asList(IntegerOperators.SUBTRACT, IntegerOperators.SUM, IntegerOperators.DIVIDE, IntegerOperators.MULTIPLY));

        return Stream.of(
                Arguments.of(operands, operators)
        );
    }

    private static Stream<Arguments> unhandledOperandExistIntegerUnits() {
        return Stream.of(
                Arguments.of(new LinkedList<>(Arrays.asList(10, 10, 20, 20, 30, 40, 50)), new LinkedList<>(Arrays.asList(IntegerOperators.SUBTRACT, IntegerOperators.SUM, IntegerOperators.DIVIDE, IntegerOperators.MULTIPLY))),
                Arguments.of(new LinkedList<>(Arrays.asList(10, 10, 20)), new LinkedList<>(Arrays.asList(IntegerOperators.SUBTRACT, IntegerOperators.SUM, IntegerOperators.DIVIDE, IntegerOperators.MULTIPLY)))
        );
    }
}
