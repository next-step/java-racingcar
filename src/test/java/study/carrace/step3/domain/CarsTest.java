package study.carrace.step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @ParameterizedTest(name = "[{index}/2] 자동차들 이동 시도 테스트")
    @CsvSource(value = {"true,true", "false,false"})
    void move_or_stop_cars(boolean movable, boolean expectedMoveStatus) {
        // given
        MoveStrategy mockMoveStrategy = mockMoveStrategy(movable);

        // when
        Cars cars = new Cars(List.of("foo", "bar"), mockMoveStrategy).moveOrStopCars(1);

        // then
        assertThat(cars).isEqualTo(new Cars(List.of(
                new Car("foo", mockMoveStrategy, new CarPosition(List.of(expectedMoveStatus))),
                new Car("bar", mockMoveStrategy, new CarPosition(List.of(expectedMoveStatus)))
        )));
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}