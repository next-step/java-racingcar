package step1.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import step1.racing.data.RacingCar;

class PositionSetterTest {
    private Evaluator<Integer> evaluator = new IntegerEvaluator();

    @ParameterizedTest
    @ValueSource(strings = { "3", "4", "5" })
    void throw_exception_if_different_args_list_size(String threshold) {
        PositionSetter<Integer> sut = new PositionSetter(evaluator, threshold);
        RacingCarHandler targetList = new RacingCarHandler(Arrays.asList(new RacingCar("a"), new RacingCar("b")));
        List<Integer> evalList = Arrays.asList(3);

        assertThatThrownBy(() -> sut.movePosition(targetList, evalList)).isInstanceOf(
                IndexOutOfBoundsException.class);
    }

    @ParameterizedTest
    @MethodSource("provideTestArgs")
    void check_position_after_moved(RacingCarHandler lists) {
        PositionSetter<Integer> sut = new PositionSetter(evaluator, "-1");
        List<Integer> evalList = Arrays.asList(3);

        sut.movePosition(lists, evalList);

        assertThat(lists.racingCars().get(0).getPosition()).isEqualTo(2);
    }

    private static Stream<Arguments> provideTestArgs() {
        return Stream.of(
                Arguments.of(new RacingCarHandler(Arrays.asList(new RacingCar("test"))))
        );
    }
}
