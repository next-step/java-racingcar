package racing;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void move() {
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 3);
        List<Car> result = racingGame.move();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void canContinue_횟수_0일때() {
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 0);
        boolean canContinue = racingGame.canContinue();
        assertThat(canContinue).isFalse();
    }

    @Test
    public void canContinue_횟수_0보다_클때() {
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 5);
        boolean canContinue = racingGame.canContinue();
        assertThat(canContinue).isTrue();
    }

    @Test
    public void getWinners_1명_우승() {
        List<Car> winners = RacingGame.getWinners(
                Arrays.asList(
                        new Car("pobi", 3)
                        , new Car("crong", 2)
                        , new Car("honux", 1))
        );

        // 우승자는 1명임.
        assertThat(winners.size()).isEqualTo(1);
    }


    @Test
    public void getWinners_공동2명_우승() {
        List<Car> winners = RacingGame.getWinners(
                Arrays.asList(
                        new Car("pobi", 3)
                        , new Car("crong", 3)
                        , new Car("honux", 1))
        );

        // 우승자는 공동 2명
        assertThat(winners.size()).isEqualTo(2);
    }


    @Test
    public void getMaxPosition() {
        Integer result = RacingGame.getMaxPosition(
                Arrays.asList(
                        new Car("tayo", 5)
                        , new Car("park", 3)
                        , new Car("jin", 2)
                )
        );

        assertThat(result).isEqualTo(5);
    }
}