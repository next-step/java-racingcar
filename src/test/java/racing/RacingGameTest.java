package racing;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void move() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(5, 3);
        racingGame.move();
    }

    @Test
    public void canMove_4미만() {
        boolean result = RacingGame.canMove(3);
        assertThat(result).isFalse();
    }

    @Test
    public void canMove_4이상() {
        boolean result = RacingGame.canMove(4);
        assertThat(result).isTrue();
    }


    @Test
    public void canContinue_횟수_0일때() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(5, 0);
        boolean canContinue = racingGame.canContinue();
        assertThat(canContinue).isFalse();
    }

    @Test
    public void canContinue_횟수_0보다_클때() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(5, 5);
        boolean canContinue = racingGame.canContinue();
        assertThat(canContinue).isTrue();
    }
}