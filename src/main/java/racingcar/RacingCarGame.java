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

        String[] carNames = StringCalculator.split(input.getCarNameCsv());
        List<RacingCar> racingCars = RacingCarFactory.createRacingCars(carNames,
            new RandomRacingCarMoveStrategy(RandomUtils.getInstance()));

        for (int i = 0; i < input.getTryCount(); i++) {
            moveIfMovable(racingCars);
            resultView.viewCurrent(racingCars);
        }

        List<RacingCar> winners = winnerStrategy.getWinners(racingCars);
        resultView.viewWinners(winners);
    }

    private void moveIfMovable(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            car.moveIfMovable();
        }
    }

}
