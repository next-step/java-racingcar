package racingGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    public void 자동차와횟수가없는경우() {
        RacingGame racingGame = new RacingGame(0, 0);

        while (racingGame.hasRemainTime()) {
            racingGame.move();
        }

        assertThat(racingGame.getCarPositions()).isEqualTo(new ArrayList<Integer>());
    }

    @Test
    public void 자동차경주하지않은경우() {
        RacingGame racingGame = new RacingGame(3, 0);

        while (racingGame.hasRemainTime()) {
            racingGame.move();
        }

        assertThat(racingGame.getCarPositions()).isEqualTo(Arrays.asList(0, 0, 0));
    }

    @Test
    public void 전진조건체크_전진가능() {
        RacingGame racingGame = new RacingGame(2, 2);

        assertThat(racingGame.isForward(4)).isEqualTo(true);
    }

    @Test
    public void 전진조건체크_전진불가능() {
        RacingGame racingGame = new RacingGame(2, 2);

        assertThat(racingGame.isForward(3)).isEqualTo(false);
        assertThat(racingGame.isForward(11)).isEqualTo(false);
    }
}