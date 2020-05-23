package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameStart {

    public static void main(String[] args) {
        int cars = InputView.inputCar();
        int times = InputView.inputTime();

        RacingCars racingCars = new RacingCars(cars);
        RacingGame racingGame = new RacingGame(racingCars);

        ResultView.resultMessage();

        for (int i = 0; i < times; i++) {
            ResultView.resultGame(racingGame.race());
        }
    }
}
