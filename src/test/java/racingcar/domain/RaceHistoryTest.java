package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceHistoryTest {

    private RaceHistory raceHistory;
    private Cars cars;

    @BeforeEach
    void setUp() {
        raceHistory = new RaceHistory();
        cars = Cars.createWithDefaults(3);
    }

    @Test
    void string() {
        cars = cars.move(() -> true);
        raceHistory = raceHistory.update(cars);
        String expected = "-\n-\n-";
        assertThat(raceHistory.toString()).isEqualTo(expected);
    }

    @Test
    void moves_multiple_times() {
        cars = cars.move(() -> true);
        raceHistory = raceHistory.update(cars);
        cars = cars.move(() -> true);
        raceHistory = raceHistory.update(cars);
        String expected = "-\n-\n-\n\n--\n--\n--";
        assertThat(raceHistory.toString()).isEqualTo(expected);
    }
}
