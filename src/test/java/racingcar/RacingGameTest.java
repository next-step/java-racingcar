package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void setup() {
        racingGame = new RacingGame();
        racingGame.readyCars("붕붕카,씽씽카,타요카");
    }

    @Test
    public void 차량_데이터_준비확인() {
        int carsSize = racingGame.getCars().size();
        assertThat(carsSize).isEqualTo(3);
    }
}
