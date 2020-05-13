package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @RepeatedTest(10)
    void getRandomPosition() {
        assertThat(racingGame.getRandomPosition()).isBetween(0, 10);
    }
}