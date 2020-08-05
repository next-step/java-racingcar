package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomFuel;
import racingcar.ui.ParameterInput;
import racingcar.ui.RacingDataInput;

public class RacingGameTest {

    private RacingDataInput input;

    @BeforeEach
    void setUp() {
        input = new ParameterInput("a,b,c", 3, 5);
    }

    @DisplayName("게임 진행 중 오류 미발생")
    @Test
    public void game() {

//        RacingGame racingGame = new RacingGame(input, new RandomFuel());
//        racingGame.start();
//        racingGame.end();
    }
}
