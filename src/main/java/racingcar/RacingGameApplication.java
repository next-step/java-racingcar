package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingGame racingGame = new RacingGame(new RacingCarMovableStrategy(), inputView.getNumberOfCars(), inputView.getTryCount());
        List<List<Integer>> raceResult = racingGame.run();

        ResultView.print(raceResult);
    }
}
