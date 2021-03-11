import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }
}