package racingcar;

import org.junit.Ignore;
import org.junit.Test;

public class ResultViewTest {
    @Ignore
    @Test
    public void 출력하기() {
        int time = 5;
        int numberOfCar = 3;
        RacingGame game = new RacingGame(numberOfCar);
        GameResult result = game.play(time);
        ResultView.print(result);
    }
}