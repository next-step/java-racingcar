package racingcar;

import racingcar.service.RacingGame;
import racingcar.domain.Cars;
import racingcar.strategy.impl.RandomBoundMovingStrategy;
import racingcar.util.InputCarNameSplitUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {

        String nameOfCars = InputView.getNameOfCar();
        String[] names = InputCarNameSplitUtils.getSplitStringArray(nameOfCars);

        int raceTrialCount = InputView.getRaceTrialCount();

        Cars cars = Cars.of(names);

        RacingGame racingGame = new RacingGame(cars, raceTrialCount);

        while(!racingGame.isEnd()) {
            racingGame.race(new RandomBoundMovingStrategy());
            ResultView.printCurrentRace(cars);
        }

        ResultView.printWinners(racingGame.findWinners());

    }

}
