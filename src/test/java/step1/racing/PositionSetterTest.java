package step1.racing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionSetterTest {
    private Evaluator<Integer> evaluator = new IntegerEvaluator();

    @ParameterizedTest
    @ValueSource(ints = { 3, 4, 5 })
    void throw_exception_if_different_args_list_size(int threshold) {
        PositionSetter<Integer> sut = new PositionSetter<>(evaluator, threshold);
        List<Integer> targetList = Arrays.asList(1, 2, 3);
        List<Integer> evalList = Arrays.asList(3);

        assertThatThrownBy(() -> sut.movePosition(targetList, evalList)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
