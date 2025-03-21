package racingcar.controller;

import java.util.List;

import racingcar.domain.DefaultRacingCarGameWinnerStrategy;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarFactory;
import racingcar.domain.RacingCarGameWinnerStrategy;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarResult;
import racingcar.view.RacingCarResultView;

public class RacingCarGameController {

    private final RacingCarInputView inputView;
    private final RacingCarResultView resultView;
    private final RacingCarGameWinnerStrategy winnerStrategy;

    public RacingCarGameController() {
        this(RacingCarInputView.getInstance(),
             RacingCarResultView.getInstance(),
             DefaultRacingCarGameWinnerStrategy.getInstance());
    }

    private RacingCarGameController(RacingCarInputView inputView,
                                    RacingCarResultView resultView,
                                    RacingCarGameWinnerStrategy winnerStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.winnerStrategy = winnerStrategy;
    }

    public void start() {
        RacingCarInput input = inputView.viewInput();

        List<RacingCar> racingCars = RacingCarFactory.createRacingCars(input.getCarNames());

        for (int i = 0; i < input.getTryCount(); i++) {
            moveIfMovable(racingCars);
            resultView.viewCurrent(RacingCarResult.of(racingCars));
        }

        List<RacingCar> winners = winnerStrategy.getWinners(racingCars);
        resultView.viewWinners(RacingCarResult.of(winners));
    }

    private void moveIfMovable(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            car.moveIfMovable();
        }
    }
}
