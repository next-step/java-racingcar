package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {
    @Test
    void test_start_race() {
        CarRace race = new CarRace(new String[]{"car1"}, 3);
        race.startRace(() -> true, (cars) -> { });
        assertThat(race.getWinners().get(0).hasDistance(new CarDistance(3))).isTrue();
    }
}
