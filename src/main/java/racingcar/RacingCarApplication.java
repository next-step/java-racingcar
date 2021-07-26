package racingcar;

import racingcar.service.RacingGame;
import racingcar.dto.Board;
import racingcar.model.Cars;
import racingcar.dto.RacingInfo;
import racingcar.strategy.impl.RandomBoundMovingStrategy;
import racingcar.util.InputCarNameSplitUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {

        String nameOfCar = InputView.getNameOfCar();
        String[] names = InputCarNameSplitUtils.getSplitStringArray(nameOfCar);
        int numberOfCar = names.length;
        int raceTrialCount = InputView.getRaceTrialCount();

        RacingInfo racingInfo = new RacingInfo(names, numberOfCar, raceTrialCount);

        Cars cars = Cars.of(racingInfo.numberOfCar);

        RacingGame racingGame = new RacingGame(racingInfo, cars);
        Board board = racingGame.gameStart(new RandomBoundMovingStrategy());

        ResultView.printResult(board);

    }

}
