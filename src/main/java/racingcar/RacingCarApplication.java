package racingcar;

import racingcar.service.RacingGame;
import racingcar.dto.Board;
import racingcar.model.Cars;
import racingcar.dto.RacingInfo;
import racingcar.strategy.impl.RandomBoundMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        int numberOfCar = InputView.getNumberOfCar();
        int raceTrialCount = InputView.getRaceTrialCount();

        RacingInfo racingInfo = new RacingInfo(numberOfCar, raceTrialCount);
        Cars cars = Cars.of(racingInfo.numberOfCar, new RandomBoundMovingStrategy());

        RacingGame racingGame = new RacingGame(racingInfo, cars);
        Board board = racingGame.gameStart();

        ResultView.printResult(board);

    }

}
