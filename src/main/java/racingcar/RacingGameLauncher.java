package racingcar;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameLauncher {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String namesOfCars = inputView.promptNamesOfCars();
        int numberOfRounds = inputView.promptNumberOfRounds();

        Car[] cars = CarFactory.createCars(namesOfCars);
        RandomNumber randomNumber = new RandomNumberImpl();
        RacingGame racingGame = new RacingGame(cars, randomNumber);

        for (int i = 0; i < numberOfRounds; i++) {
            racingGame.runSingleRound();
            resultView.showCarsDistance(cars);
        }

        resultView.showWinners(racingGame.getWinners());
    }

}
