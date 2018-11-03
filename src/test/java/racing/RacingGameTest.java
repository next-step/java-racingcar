package racing;

import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void start() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(5, 3);
        racingGame.start();
    }

    @Test
    public void move() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(5, 3);
        racingGame.move();
    }

    @Test
    public void canMove_4이하() {
        int result = RacingGame.canMove(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void canMove_4이상() {
        int result = RacingGame.canMove(4);
        assertThat(result).isEqualTo(1);
    }
}