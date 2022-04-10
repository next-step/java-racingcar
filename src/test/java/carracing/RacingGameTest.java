package carracing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void 자동차_대수에_맞게_경주_준비(int input) {
        assertThat(RacingGame.initRacingCars(input)).hasSize(input);
    }
}