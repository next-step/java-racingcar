package racing.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


public class RacingGameTest {

    private RacingGame game;

    private final String[] carNames = new String[] {"pobi", "crong", "honux"};
    private final int times = 2;

    @Before
    public void setup() {
        game = new RacingGame(times, carNames);
    }

    @Test
    public void 레이싱_정상동작_확인() {
        gameStart();

        assertThat(game.isFinish()).isTrue();
        assertThat(game.getResultOfTheGame().size()).isEqualTo(carNames.length);
    }

    @Test
    public void 레이싱_진행중_확인() {
        game.move();

        assertThat(game.isFinish()).isFalse();
        assertThat(game.getResultOfTheGame().size()).isEqualTo(carNames.length);
    }

    @Test
    public void 레이싱_게임끝난뒤_이동안되는것_확인() {
        gameStart();

        assertThat(game.isFinish()).isTrue();

        try{
            game.move();
            fail("RacingGame is over.");
        } catch (RacingGameException e) { }
    }

    private void gameStart() {
        for (int i = 0; i < times; i++) {
            game.move();
        }
    }
}