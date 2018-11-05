package racing;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void move() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 3);
        racingGame.move();
    }

    @Test
    public void canContinue_횟수_0일때() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 0);
        boolean canContinue = racingGame.canContinue();
        assertThat(canContinue).isFalse();
    }

    @Test
    public void canContinue_횟수_0보다_클때() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 5);
        boolean canContinue = racingGame.canContinue();
        assertThat(canContinue).isTrue();
    }

    @Test
    public void getWinners() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 5);
        racingGame.move();
        List<Car> winners = racingGame.getWinners();

        // 우승자는 1명이상임.
        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void getMaxPosition() throws NoSuchAlgorithmException {
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 5);
        racingGame.move();
        Integer result = racingGame.getMaxPosition();

        assertThat(result).isGreaterThanOrEqualTo(0);
    }
}