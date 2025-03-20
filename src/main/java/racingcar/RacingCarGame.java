package racingcar;

import java.util.List;

import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarResult;
import racingcar.ui.RacingCarResultView;
import utils.RandomUtils;

public class RacingCarGame {

    private final RacingCarInputView inputView;
    private final RacingCarResultView resultView;
    private final RacingCarGameWinnerStrategy winnerStrategy;

    public RacingCarGame(RacingCarInputView inputView,
                         RacingCarResultView resultView,
                         RacingCarGameWinnerStrategy winnerStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.winnerStrategy = winnerStrategy;
    }

    public void start() {
        RacingCarInput input = inputView.viewInput();

        List<RacingCar> racingCars = RacingCarFactory.createRacingCars(input.getCarNames());
        RandomRacingCarMoveStrategy moveStrategy
            = new RandomRacingCarMoveStrategy(RandomUtils.getInstance());


        for (int i = 0; i < input.getTryCount(); i++) {
            moveIfMovable(racingCars, moveStrategy);
            resultView.viewCurrent(RacingCarResult.of(racingCars));
        }

        List<RacingCar> winners = winnerStrategy.getWinners(racingCars);
        resultView.viewWinners(RacingCarResult.of(winners));
    }

    private void moveIfMovable(List<RacingCar> racingCars, RacingCarMoveStrategy moveStrategy) {
        for (RacingCar car : racingCars) {
            car.moveIfMovable(moveStrategy);
        }
    }
}
