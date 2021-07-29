package racingcar;

import racingcar.service.RacingGame;
import racingcar.dto.Board;
import racingcar.domain.Cars;
import racingcar.dto.RacingInfo;
import racingcar.strategy.impl.RandomBoundMovingStrategy;
import racingcar.util.InputCarNameSplitUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {

        String nameOfCars = InputView.getNameOfCar();
        String[] names = InputCarNameSplitUtils.getSplitStringArray(nameOfCars);
        int numberOfCar = names.length;
        int raceTrialCount = InputView.getRaceTrialCount();

        RacingInfo racingInfo = new RacingInfo(numberOfCar, raceTrialCount);

        Cars cars = Cars.of(names);

        RacingGame racingGame = new RacingGame(racingInfo, cars);

        Board board;

        for(int i = 0 ; i < raceTrialCount ; i++) {
            board = racingGame.race(new RandomBoundMovingStrategy());
            ResultView.printCurrentRace(board);
        }

        ResultView.printWinners(racingGame.findWinners());

    }

}
