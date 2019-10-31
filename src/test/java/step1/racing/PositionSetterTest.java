package step1.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionSetterTest {
    private Evaluator<Integer> evaluator = new IntegerEvaluator();

    @ParameterizedTest
    @ValueSource(strings = { "3", "4", "5" })
    void throw_exception_if_different_args_list_size(String threshold) {
        PositionSetter<Integer> sut = new PositionSetter(evaluator, threshold);
        List<Integer> targetList = Arrays.asList(1, 2, 3);
        List<Integer> evalList = Arrays.asList(3);

        assertThatThrownBy(() -> sut.movePosition(targetList, evalList)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1"})
    void check_position_actually_moved(String threshold) {
        PositionSetter<Integer> sut = new PositionSetter(evaluator, threshold);
        List<Integer> targetList = Arrays.asList(0, 0, 0);
        List<Integer> evalList = Arrays.asList(3, 3, 3);

        targetList = sut.movePosition(targetList, evalList);
        targetList = sut.movePosition(targetList, evalList);
        targetList = sut.movePosition(targetList, evalList);
        targetList = sut.movePosition(targetList, evalList);
        targetList = sut.movePosition(targetList, evalList);

        assertThat(targetList.get(0)).isEqualTo(5);
        assertThat(sut.movePosition(targetList, evalList).get(0)).isEqualTo(6);
    }


}
