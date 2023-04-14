package study.carrace.step3.application;

import org.junit.jupiter.api.Test;
import study.carrace.step3.domain.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceManagerTest {
    @Test
    void cars_position() {
        // given
        List<String> carNames = List.of("foo", "bar");
        RaceManager raceManager = new RaceManager(carNames, mockMoveStrategy(true));

        raceManager.moveOrStopCars();
        raceManager.moveOrStopCars();

        // when, then
        String expected = new StringBuilder()
                .append("foo : --\n")
                .append("bar : --\n")
                .toString();
        assertThat(raceManager.carsPosition()).isEqualTo(expected);
    }

    @Test
    void winners() {
        // given
        List<String> carNames = List.of("foo", "bar");
        RaceManager raceManager = new RaceManager(carNames, mockMoveStrategy(true));

        raceManager.moveOrStopCars();

        // when
        assertThat(raceManager.winners()).containsExactly("foo", "bar");
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}