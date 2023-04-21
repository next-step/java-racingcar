package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @ParameterizedTest(name = "[{index}/2] 자동차들 이동 시도 테스트")
    @CsvSource(value = {"true,true", "false,false"})
    void move_or_stop_cars(boolean movable, boolean expectedMoveStatus) {
        // given
        MoveStrategy mockMoveStrategy = mockMoveStrategy(movable);
        Cars cars = new Cars(List.of("foo", "bar"), mockMoveStrategy);

        // when
        cars.moveOrStopCars();

        // then
        assertThat(cars).isEqualTo(new Cars(List.of(
                new Car("foo", mockMoveStrategy, new CarPosition(List.of(expectedMoveStatus))),
                new Car("bar", mockMoveStrategy, new CarPosition(List.of(expectedMoveStatus)))
        )));
    }

    @ParameterizedTest(name = "[{index}/3] 자동차들 위치 반환")
    @MethodSource("carsPosition")
    void cars_position_at(int iteration, String expectedCarsPosition) {
        // given
        Cars cars = new Cars(List.of(
                new Car("foo", null, new CarPosition(List.of(true, false, true))),
                new Car("bar", null, new CarPosition(List.of(true, true, false))),
                new Car("baz", null, new CarPosition(List.of(false, false, true)))
        ));

        // when, then
        assertThat(cars.carsPositionAt(iteration)).isEqualTo(expectedCarsPosition);
    }

    @Test
    void first_rankers() {
        // given
        Cars cars = new Cars(List.of(
                new Car("foo", null, new CarPosition(List.of(true, false, true))),
                new Car("bar", null, new CarPosition(List.of(true, true, false))),
                new Car("baz", null, new CarPosition(List.of(false, false, true)))
        ));

        // when, then
        assertThat(cars.firstRankers()).containsExactly(new CarName("foo"), new CarName("bar"));
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }

    static Stream<Arguments> carsPosition() {
        return Stream.of(
                Arguments.of(1, "foo : -\nbar : -\nbaz : \n"),
                Arguments.of(2, "foo : -\nbar : --\nbaz : \n"),
                Arguments.of(3, "foo : --\nbar : --\nbaz : -\n")
        );
    }
}