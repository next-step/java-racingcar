package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        int time = InputView.askTime();
        int carCount = InputView.askCarCount();

        RacingGame game = new RacingGame(time, carCount);
        RacingResult result = game.run();

        ResultView.print(result);
    }
}
