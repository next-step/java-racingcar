package domain;

import org.junit.jupiter.api.Test;
import util.RacingCarUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    public static final int CAR_NUMBER = 3;
    public static final int RANDOM_MAX = 10;
    public static final int RANDOM_MIN = 0;

    @Test
    public void create() {
        RacingGame racingGame = new RacingGame(CAR_NUMBER);
        assertThat(racingGame.equals(new RacingGame(CAR_NUMBER))).isEqualTo(true);
    }

    @Test
    public void getRandomNumber() {
        for (int i = 0; i < 50; i++) {
            assertThat(RacingCarUtil.getRandomNumber(RANDOM_MAX)).isLessThan(RANDOM_MAX);
            assertThat(RacingCarUtil.getRandomNumber(RANDOM_MIN)).isGreaterThanOrEqualTo(RANDOM_MIN);
        }
    }

    @Test
    public void move() {
        RacingGame racingGame = new RacingGame(CAR_NUMBER);
        assertThat(racingGame.move()).hasSize(3);
    }

}
