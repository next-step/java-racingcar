package racingcar.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        this.racingGame = new RacingGame(5, 3);
    }

    @Test
    void start() {
        racingGame.start();
    }
}
