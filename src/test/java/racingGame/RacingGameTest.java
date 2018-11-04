package racingGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    public void 자동차와횟수가없는경우() {
        RacingGame racingGame = new RacingGame();
        ArrayList<Integer> result = racingGame.move(0, 0);

        assertThat(result).isEqualTo(new ArrayList<Integer>());
    }

    @Test
    public void 자동차가경주하지않는경우() {
        RacingGame racingGame = new RacingGame();
        ArrayList<Integer> result = racingGame.move(3, 0);

        assertThat(result).isEqualTo(Arrays.asList(0, 0, 0));
    }
}