package racingcar;

import java.util.List;

import calculator.StringCalculator;
import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarInputView;
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

        RacingCarManager carManager = new RacingCarManager(racingCars);

        for (int i = 0; i < input.getTryCount(); i++) {
            carManager.moveIfMovable(moveStrategy);
            resultView.viewCurrent(carManager.getRacingCars());
        }

        List<RacingCar> winners = winnerStrategy.getWinners(carManager.getRacingCars());
        resultView.viewWinners(winners);
    }
}
