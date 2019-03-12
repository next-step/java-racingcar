
package racingcar;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import racingcar.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame;

    @Before
    public void setUp() {
        racingGame = new RacingGame(3, 5);
    }

    //여기는 테스트 코드를 어떻게 짜면 좋을지;;;
    @Test
    public void 게임시작() {
        racingGame.play();
    }

    @After
    public void tearDown() {
        racingGame = null;
    }
}
