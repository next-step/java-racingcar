package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void 입력된_라운드_수만큼_레이스를_한다(int numberOfAttempts) {
        RacingGame game = new RacingGame(1, numberOfAttempts);
        assertThat(game.run()).hasSize(numberOfAttempts);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void 입력된_자동차_수만큼_자동차가_생성된다(int numberOfCars) {
        RacingGame game = new RacingGame(numberOfCars, 1);
        assertThat(game.run().get(0)).hasSize(numberOfCars);
    }
}
