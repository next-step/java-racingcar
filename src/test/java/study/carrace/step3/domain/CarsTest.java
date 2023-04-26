package study.carrace.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
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

    @DisplayName("공백 Car 리스트를 인스턴스 변수를 가지고 있는 Cars 객체에서 first_rankers 메소드 호출 시, 공백 리스트 반환")
    @Test
    void empty_first_rankers() {
        // given
        Cars cars = new Cars(Collections.emptyList());

        // when, then
        assertThat(cars.firstRankers()).isEmpty();
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}