package study.carrace.step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carrace.step3.domain.CarName;
import study.carrace.step3.domain.Cars;
import study.carrace.step3.domain.MoveStrategy;
import study.carrace.step3.domain.exception.IllegalIterationCountException;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceManagerTest {
    @Test
    void invalid_iteration_count() {
        // given
        int iterationCount = -1;

        // when, then
        assertThatThrownBy(() -> new RaceManager(List.of("foo", "bar"), mockMoveStrategy(true), iterationCount))
                .isInstanceOf(IllegalIterationCountException.class)
                .hasMessage("시도 횟수는 한번 이상이여야 합니다: " + iterationCount);
    }

    @Test
    void winners() {
        // given
        List<String> carNames = List.of("foo", "bar");
        RaceManager raceManager = new RaceManager(carNames, mockMoveStrategy(true), 1);

        // when
        raceManager.startRace();

        // then
        assertThat(raceManager.winners()).containsExactly(new CarName("foo"), new CarName("bar"));
    }

    @DisplayName("startRace() 메소드 호출 시, 레이스가 완료된 Cars 객체 반환")
    @Test
    void start_race() {
        // given
        List<String> carNames = List.of("foo", "bar");
        MoveStrategy mockMoveStrategy = mockMoveStrategy(true);
        int iterationCount = 1;

        RaceManager raceManager = new RaceManager(carNames, mockMoveStrategy, iterationCount);

        // when
        Cars cars = raceManager.startRace();

        // then
        Cars movedOrStoppedCars = new Cars(carNames, mockMoveStrategy).moveOrStopCars(iterationCount);
        assertThat(cars).isEqualTo(movedOrStoppedCars);
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}