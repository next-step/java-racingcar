package study.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    private void setUp() {
        racingGame = new RacingGame(3, 5);
    }

    @Test
    void play() {
        racingGame.play();
    }
}
