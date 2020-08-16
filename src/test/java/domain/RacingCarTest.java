package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.BDDAssertions.then;

class RacingCarTest {

    private static final String DEFAULT_NAME = "name";

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(DEFAULT_NAME);
    }

    @ParameterizedTest
    @DisplayName("test getName()")
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void getName(String name) {
        RacingCar racingCar = new RacingCar(name);
        then(racingCar.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("test racord()")
    void record() {
        int expected = 0;
        then(racingCar.record()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("test race()")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void race(int bound, int laps) {
        racingCar.race(bound);
        then(racingCar.record()).isEqualTo(laps);
    }
}
