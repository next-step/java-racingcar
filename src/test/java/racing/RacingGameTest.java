package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.Test;


public class RacingGameTest {

    @Test
    public void 레이싱정상동작() {
        RacingGame game = new RacingGame(2, 3);

        int[] gameResult = null;

        gameResult = game.move();
        gameResult = game.move();

        assertThat(game.isReady()).isFalse();
        assertThat(game.isRacing()).isFalse();
        assertThat(game.isFinish()).isTrue();
        assertThat(gameResult.length).isEqualTo(3);
    }

    @Test
    public void 레이싱래뒤상태() {
        RacingGame game = new RacingGame(2, 3);

        int[] gameResult = null;

        assertThat(game.isReady()).isTrue();
        assertThat(game.isRacing()).isFalse();
        assertThat(game.isFinish()).isFalse();
    }

    @Test
    public void 레이싱게임중() {
        RacingGame game = new RacingGame(2, 3);

        int[] gameResult = null;

        gameResult = game.move();

        assertThat(game.isReady()).isFalse();
        assertThat(game.isRacing()).isTrue();
        assertThat(game.isFinish()).isFalse();
        assertThat(gameResult.length).isEqualTo(3);
    }


    @Test
    public void 레이싱완료후이동() {
        RacingGame game = new RacingGame(2, 3);

        int[] gameResult = null;

        try {
            game.move();
            game.move();
            game.move();
            fail("Racing Game is finish.");
        } catch (RuntimeException e) {
        }
    }
}