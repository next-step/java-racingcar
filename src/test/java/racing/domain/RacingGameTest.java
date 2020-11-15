package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void run() {
        RacingGame racingGame = new RacingGame("test, 1, 2", 1);
        Assertions.assertThat(racingGame.run().size())
                .isEqualTo(4);
    }

    @Test
    void getCars() {
        RacingGame racingGame = new RacingGame("test, 1, 2", 1);
        Assertions.assertThat(racingGame.getCars().getCarList().size())
                .isEqualTo(3);
    }
}