package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarDTO;
import racingcar.domain.RacingCarConfiguration;
import racingcar.domain.RandomStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGameController {
    private ResultView resultView;
    private InputView inputView;
    private List<Car> racingCars;
    private RacingCarConfiguration racingCarConfiguration;
    private int repeatCount;

    public RacingGameController() {
        this.resultView = new ResultView();
        this.inputView = new InputView();
    }


    public void readyGame() {
        resultView.ready();
        repeatCount = inputView.getRepeatCount();
        resultView.printSpace();
    }

    public void racingResult() {
        resultView.show(racingCarConfiguration.findWinningCarNames());
    }

    public void createCarBy(String racingCarNameList) {
        String[] carNames = racingCarNameList.split(",");
        this.racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
    }

    public List<CarDTO> race() {
        List<CarDTO> carDTOS = new ArrayList<>();
        for (Car car : racingCars) {
            car.move(new RandomStrategy());
            carDTOS.add(car.toDTO());
        }

        return carDTOS;
    }
}
