package racingcar.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        GameRole gameRole = new GameRole(1);
        this.racingGame = new RacingGame(5, 3, gameRole);
    }

    @Test
    void start() {
        racingGame.start();
    }
}
