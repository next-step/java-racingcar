package racingGame;

import org.junit.Test;

import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    public void 자동차와횟수가없는경우() {
        RacingGame racingGame = new RacingGame();
        ArrayList<Integer> result = racingGame.move(0, 0);

        assertThat(result).isEqualTo(new ArrayList<Integer>());
    }
}