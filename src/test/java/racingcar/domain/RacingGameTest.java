package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.ParameterInput;
import racingcar.ui.RacingDataInput;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingDataInput input;

    @BeforeEach
    void setUp() {
        input = new ParameterInput("a,b,c", 3, 5);
    }

    @DisplayName("게임 진행 중 오류 미발생")
    @Test
    public void game() {

        Engine engine = new Engine(() -> 5);

        RacingGame racingGame = new RacingGame(input, engine);
        racingGame.start();
        racingGame.end();

        assertThat(racingGame.getWinnerNames()).isEqualTo("a, b, c");
    }
}
