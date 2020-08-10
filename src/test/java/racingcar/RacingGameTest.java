package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    static RacingGame racingGame;
    @BeforeEach
    public static void setUp() {
        racingGame = new RacingGame();
    }


    @Test
    public void 레이싱게임준비() {
        racingGame.readyRacingGame();
    }

    @Test
    public void startRacingGame() {

    }
}
