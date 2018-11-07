package racingGame;

import org.junit.Before;
import org.junit.Test;
import racingGame.model.RacingCarVO;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @Before
    public void setUp() {
        String[] carNames = {"test1", "test2"};
        racingGame = new RacingGame(carNames, 2);
    }

    @Test
    public void 경주시작하지않은경우() {
        List<RacingCarVO> snapshots = racingGame.getRacingCarSnapshots();
        assertThat(snapshots.get(0).getPosition()).isEqualTo(0);
        assertThat(snapshots.get(1).getPosition()).isEqualTo(0);
        assertThat(racingGame.hasRemainTime()).isEqualTo(true);
    }

    @Test(expected = IllegalStateException.class)
    public void 경주하지않았는데_우승정보_조회하는_경우() {
        racingGame.getFinishedCarSnapshots();
    }

    @Test
    public void 경주완료한경우() {
        while (racingGame.hasRemainTime()) {
            racingGame.move();
        }

        assertThat(racingGame.hasRemainTime()).isEqualTo(false);
    }
}