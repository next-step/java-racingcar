package racingcar;

import java.util.List;

import calculator.StringCalculator;
import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarResultView;
import utils.RandomUtils;

public class RacingCarGame {

    private final RacingCarGameWinnerStrategy winnerStrategy;

    public RacingCarGame(RacingCarGameWinnerStrategy winnerStrategy) {
        this.winnerStrategy = winnerStrategy;
    }

    public void start() {
        RacingCarInput input = RacingCarInputView.view();

        String[] carNames = StringCalculator.split(input.getCarNameCsv());
        List<RacingCar> racingCars = RacingCarFactory.createRacingCars(carNames,
            new RandomRacingCarMoveStrategy(RandomUtils.getInstance()));

        for (int i = 0; i < input.getTryCount(); i++) {
            moveIfMovable(racingCars);
            RacingCarResultView.view(racingCars);
        }

        List<RacingCar> winners = winnerStrategy.getWinners(racingCars);
        RacingCarResultView.winnersView(winners);
    }

    private void moveIfMovable(List<RacingCar> racingCarList) {
        for (RacingCar car : racingCarList) {
            car.moveIfMovable();
        }
    }

}
