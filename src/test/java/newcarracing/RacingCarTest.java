package newcarracing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 경주용_자동차(String input) {
        RacingCar racingCar = new RacingCar(input);
        assertThat(racingCar.getName()).isEqualTo(input);
    }
}