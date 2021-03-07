import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void testStart() {
        racingGame.start();
    }
}