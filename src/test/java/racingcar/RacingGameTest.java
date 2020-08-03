package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.ui.ParameterInput;
import racingcar.ui.RacingDataInput;

public class RacingGameTest {

    private RacingDataInput input;

    @BeforeEach
    void setUp() {
        input = new ParameterInput(3, 5);
    }

    @Test
    public void test() {

        RacingGame racingGame = new RacingGame(input);
        racingGame.start();
    }
}
