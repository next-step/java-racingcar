package study.carrace.step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carrace.step3.application.dto.RaceFinishedCar;
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

    @DisplayName("startRace() 메소드 호출 시, List<RaceFinishedCar> 객체 반환")
    @Test
    void start_race() {
        // given
        List<String> carNames = List.of("foo", "bar");
        MoveStrategy mockMoveStrategy = mockMoveStrategy(true);
        int iterationCount = 1;

        RaceManager raceManager = new RaceManager(carNames, mockMoveStrategy, iterationCount);

        // when
        List<RaceFinishedCar> raceFinishedCars = raceManager.startRace();

        // then
        List<RaceFinishedCar> expectedRaceFinishedCars = List.of(
                new RaceFinishedCar("foo", List.of(true)),
                new RaceFinishedCar("bar", List.of(true))
        );
        assertThat(raceFinishedCars).isEqualTo(expectedRaceFinishedCars);
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}