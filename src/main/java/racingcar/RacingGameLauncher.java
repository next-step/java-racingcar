package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameLauncher {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String namesOfCars = inputView.promptNamesOfCars();
        int numberOfRounds = inputView.promptNumberOfRounds();

        Car[] cars = CarFactory.createCars(namesOfCars);
        RacingGame racingGame = new RacingGame(cars);

        for (int i = 0; i < numberOfRounds; i++) {
            racingGame.runSingleRound();
            resultView.showCarsDistance(cars);
        }

        resultView.showWinners(racingGame.getWinners());
    }

}
