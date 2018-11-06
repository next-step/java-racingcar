package racingGame;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @Before
    public void setUp() {
        String[] carNames = {"test1", "test2"};
        racingGame = new RacingGame(carNames, 2);
    }

    @Test
    public void 전진조건체크_전진가능() {
        assertThat(racingGame.isForward(4)).isEqualTo(true);
    }

    @Test
    public void 전진조건체크_전진불가능() {
        assertThat(racingGame.isForward(3)).isEqualTo(false);
        assertThat(racingGame.isForward(11)).isEqualTo(false);
    }

    @Test
    public void 경주시작하지않은경우() {
        Map<String, Integer> carSnapshot = racingGame.getRacingCarSnapshot();
        assertThat(carSnapshot.get("test1")).isEqualTo(0);
        assertThat(carSnapshot.get("test2")).isEqualTo(0);
        assertThat(racingGame.hasRemainTime()).isEqualTo(true);
    }

    @Test(expected = IllegalStateException.class)
    public void 경주하지않았는데_우승정보_조회하는_경우() {
        racingGame.getChampionCarNames();
    }

    @Test
    public void 경주완료한경우() {
        while (racingGame.hasRemainTime()) {
            racingGame.move();
        }

        assertThat(racingGame.hasRemainTime()).isEqualTo(false);
    }
}