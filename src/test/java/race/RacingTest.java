package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.RacingGame;
import racing.model.Racing;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    RacingGame racingGame;

    @BeforeEach
    void setting() {
        racingGame = new RacingGame(5);
    }

    @Test
    @DisplayName("endGame test")
    void endGameTest() {
        racingGame.gameStart(new Racing(new String[]{"test1", "test2", "test3"}));
        assertThat(racingGame.endGame()).isEqualTo(true);
    }


}
