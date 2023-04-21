package study.carrace.step3.application;

import org.junit.jupiter.api.Test;
import study.carrace.step3.domain.CarName;
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
        assertThatThrownBy(() -> new RaceManager(null, null, iterationCount))
                .isInstanceOf(IllegalIterationCountException.class)
                .hasMessage("시도 횟수는 한번 이상이여야 합니다: " + iterationCount);
    }

    @Test
    void cars_position_history() {
        // given
        List<String> carNames = List.of("foo", "bar");
        RaceManager raceManager = new RaceManager(carNames, mockMoveStrategy(true), 2);

        // when
        raceManager.startRace();

        // then
        String expected = new StringBuilder()
                .append("foo : -\n")
                .append("bar : -\n\n")
                .append("foo : --\n")
                .append("bar : --\n\n")
                .toString();
        assertThat(raceManager.carsPositionHistory()).isEqualTo(expected);
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

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}