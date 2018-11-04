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
    public void 자동차경주하지않은경우() {
        RacingGame racingGame = new RacingGame();
        ArrayList<Integer> result = racingGame.move(3, 0);

        assertThat(result).isEqualTo(Arrays.asList(0, 0, 0));
    }

    @Test
    public void 자동차경주가능한경우() {
        RacingGame racingGame = new RacingGame();
        ArrayList<Integer> result = racingGame.move(3, 5);

        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void 전진조건체크_전진가능() {
        RacingGame racingGame = new RacingGame();

        assertThat(racingGame.isForward(4)).isEqualTo(true);
    }

    @Test
    public void 전진조건체크_전진불가능() {
        RacingGame racingGame = new RacingGame();

        assertThat(racingGame.isForward(3)).isEqualTo(false);
        assertThat(racingGame.isForward(11)).isEqualTo(false);
    }

    @Test
    public void 전진랜덤값범위체크() {
        RacingGame racingGame = new RacingGame();

        assertThat(racingGame.getLotteryNumber()).isLessThan(11);
        assertThat(racingGame.getLotteryNumber()).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void 전진후상태체크() {
        RacingGame racingGame = new RacingGame();
        ArrayList<Integer> carPositions = new ArrayList<>(Arrays.asList(0, 0, 0));
        racingGame.setForward(carPositions, 1);

        assertThat(carPositions).isEqualTo(new ArrayList<>(Arrays.asList(0, 1, 0)));
    }
}