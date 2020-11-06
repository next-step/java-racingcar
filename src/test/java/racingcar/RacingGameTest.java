package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private static final int CARS = 3;
    private static final int ATTEMPTS = 5;

    @Test
    public void makeCars() {
        RacingGame racingGame = new RacingGame(CARS, ATTEMPTS);
        assertThat(racingGame.getCarList().size()).isEqualTo(CARS);
    }
}
