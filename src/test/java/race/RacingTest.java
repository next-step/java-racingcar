package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.controller.TestRacingGame;
import racing.controller.RacingGame;
import racing.model.Car;
import racing.model.Racing;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private static int GAME_COUNT = 5;

    @Test
    @DisplayName("endGame test")
    void endGameTest() {
        RacingGame racingGame = new RacingGame(GAME_COUNT);
        Racing racing = new Racing(new String[]{"test1", "test2", "test3"});
        racingGame.gameStart(racing);
        assertThat(racingGame.endGame()).isEqualTo(true);
    }

}
