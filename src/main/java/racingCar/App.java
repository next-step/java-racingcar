package racingCar;

import racingCar.model.RacingGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class App {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int playCount = InputView.getPlayCount();

        RacingGame racingGame = new RacingGame(carNames, playCount);
        ResultView.printCarsLocation(racingGame);
    }
}
