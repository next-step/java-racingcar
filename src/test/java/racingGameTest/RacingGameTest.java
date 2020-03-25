package racingGameTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @DisplayName("Test for 'RacingGame', 'moveCar'")
    @Test
    void racingTest() {
        int cars = 3;
        int rounds = 5;

        RacingGame racingGame = new RacingGame(cars, rounds);
        assertThat(racingGame.racing().length).isEqualTo(cars);
    }
}
