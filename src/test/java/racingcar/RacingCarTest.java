package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.BDDAssertions.then;

class RacingCarTest {

    private static final String DEFAULT_NAME = "name";
    private static final int BEGIN_INDEX = 0;

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
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void race(int rounds) {
        IntStream.range(BEGIN_INDEX, rounds).forEach(round -> racingCar.race());
        then(racingCar.record()).matches(laps -> BEGIN_INDEX <= laps && laps <= rounds);
    }
}
