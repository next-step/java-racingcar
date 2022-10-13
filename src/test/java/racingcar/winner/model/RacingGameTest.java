package racingcar.winner.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void play() {
        Cars cars = new Cars(new CarFactory(new String[] {"a", "b"}).build());
        GameAttemptCount gameAttemptCount = new GameAttemptCount(1);

        RacingGame racingGame = new RacingGame(cars, gameAttemptCount);

        racingGame = racingGame.play();

        Assertions.assertThat(racingGame.isGameEnded()).isTrue();
    }
}
