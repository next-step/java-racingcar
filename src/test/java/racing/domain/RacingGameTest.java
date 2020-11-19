package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void runAndGetRancingRecodes() {
        RacingGame racingGame = new RacingGame("test, 1, 2", 1);
        racingGame.run();
        Assertions.assertThat(racingGame.getRancingRecodes().size())
                .isEqualTo(3);
    }

    @Test
    void getCars() {
        RacingGame racingGame = new RacingGame("test, 1, 2", 1);
        Assertions.assertThat(racingGame.getCars().getCarList().size())
                .isEqualTo(3);
    }
}