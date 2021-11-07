package edu.nextstep.camp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RaceTest {
    @ParameterizedTest(name = "create with invalid values: {arguments}")
    @CsvSource(value = {"0, 0", "-1, 5", "7, -1"})
    public void createFail(int cars, int turn) {
        assertThatIllegalArgumentException().isThrownBy(() -> Race.of(cars, turn));
    }

    @ParameterizedTest(name = "create race test: {arguments}")
    @CsvSource(value = {"1, 1", "53, 15", "7000, 12000"})
    public void create(int cars, int turn) {
        final Race race = Race.of(cars, turn);
        assertThat(race.numberOfCars()).isEqualTo(cars);
        assertThat(race.totalTurns()).isEqualTo(turn);
    }

    @Test
    @DisplayName("get game result(initial status)")
    public void gameResult() {
        final int numberOfCars = 4;
        final Race race = Race.of(numberOfCars, 1);
        assertThat(race.gameResult()).containsExactly(0, 0, 0, 0);
    }

    @Test
    @DisplayName("process game during given turns")
    public void process() {
        final int turns = 1;
        final Race race = Race.of(1, turns);
        race.process();
        assertThat(race.gameResult()).containsExactly(turns);
        race.process();
        assertThat(race.gameResult()).containsExactly(turns);
    }

    @Test
    @DisplayName("process all turns")
    public void processAll() {
        final int turns = 4;
        final Race race = Race.of(1, turns);
        race.processAll();
        assertThat(race.gameResult()).containsExactly(turns);
        race.process();
        assertThat(race.gameResult()).containsExactly(turns);

    }
}
