package racing;

import org.junit.Test;
import racing.domain.RacingGame;

import java.util.Arrays;

public class RacingGameTest {
    private RacingGame racingGame;

    @Test
    public void racingGameTest() {
        this.racingGame = new RacingGame(Arrays.asList("SHIN,YEON"), 5);
    }

}