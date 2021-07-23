package racingcar;

import racingcar.Service.RacingGame;
import racingcar.model.Cars;
import racingcar.model.RacingInfo;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        int numberOfCar = InputView.getNumberOfCar();
        int raceTrialCount = InputView.getRaceTrialCount();

        RacingInfo racingInfo = new RacingInfo(numberOfCar, raceTrialCount);
        Cars cars = new Cars(racingInfo.numberOfCar);

        RacingGame racingGame = new RacingGame(racingInfo, cars);
        ResultView resultView = racingGame.gameStart();

        resultView.printResult();

    }

}
