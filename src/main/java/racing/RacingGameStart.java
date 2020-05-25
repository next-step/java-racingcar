package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameStart {

    public static void main(String[] args) {
        String inputNames = InputView.inputCarNames();
        int times = InputView.inputTime();

        RacingCars racingCars = new RacingCars(inputNames);

        ResultView.resultMessage();

        for (int i = 0; i < times; i++) {
            ResultView.resultGame(racingCars.moveCars(new CarForwardBehavior()));
        }
    }
}
