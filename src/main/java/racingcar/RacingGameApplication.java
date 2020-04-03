package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new RacingCarMovableStrategy(), InputView.inputNumberOfCars(), InputView.inputTryCount());
        List<List<Integer>> raceResult = racingGame.run();

        ResultView.print(raceResult);
    }
}
