package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class RacingGameTest {

    @Test
    public void test() {

        System.setIn(new ByteArrayInputStream("3".getBytes()));
        RacingGame racingGame = new RacingGame();
        racingGame.start();
        racingGame.printResult();
    }
}
