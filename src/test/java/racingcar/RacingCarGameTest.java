package racingcar;

import java.util.Random;

import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    @Test
    void gameStart() {
        RacingCarGame racingCarGame = new RacingCarGame(3, 3);
        racingCarGame.gameStart();
    }
}