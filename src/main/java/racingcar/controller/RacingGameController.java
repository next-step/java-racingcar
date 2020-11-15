package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.CarDTO;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private static final int ZERO = 0;
    private RacingGame racingGame;
    private InputView inputView;
    private ResultView resultView;

    public RacingGameController() {
        this.racingGame = new RacingGame();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void createRacingCars() {
        String carNames = inputView.inputCarNames();
        racingGame.createCars(carNames);
    }

    public void race() {
        int repeatCount = inputView.getRepeatCount();
        if (repeatCount < ZERO) {
            throw new IllegalArgumentException("1 이상의 숫자가 필요합니다.");
        }

        for (int count = 0; count < repeatCount; count++) {
            List<Car> race = racingGame.race();
            resultView.showRacingResult(toDTO(race));
        }
    }

    public void findWinner() {
        List<Car> winners = racingGame.findWinner();
        resultView.show(toDTO(winners));
    }

    private List<CarDTO> toDTO(List<Car> cars) {
        List<CarDTO> carDTOS = new ArrayList<>();
        for (Car car : cars) {
            carDTOS.add(new CarDTO(car));
        }
        return carDTOS;
    }
}
