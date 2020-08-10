package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.BDDAssertions.then;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @ParameterizedTest
    @DisplayName("setName and getName")
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void setNameAndGetName(String name) {
        racingCar.setName(name);
        then(racingCar.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("racord")
    void record() {
        int expected = 0;
        then(racingCar.record()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("race")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void race(int rounds) {
        IntStream.range(0, rounds).forEach(round -> racingCar.race());
        then(racingCar.record()).matches(laps -> 0 <= laps && laps <= rounds);
    }
}
