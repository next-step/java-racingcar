package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingCarConfiguration;
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

    public void startRacingGame() {
        resultView.intro();
    }

    public void enterCars() {
        resultView.enterCar();
        inputView.getEnterCars();


        this.racingCars = this.racingCarConfiguration.enterCar(inputView.getEnterCars());
    }

    public void readyGame() {
        resultView.ready();
        repeatCount = inputView.getRepeatCount();
        resultView.printSpace();
    }

    public void startGame() {
        resultView.showRacingResult();
        IntStream.range(0, repeatCount).forEach(repeat -> racing());
    }

    private void racing() {
        racingCars.stream().forEach(this::move);
        resultView.printSpace();
    }

    private void move(Car car) {
//        car.move();
        resultView.showPlace(car);
    }

    public void racingResult() {
        resultView.show(racingCarConfiguration.findWinningCarNames());
    }

    public void createCar() {
        resultView.enterCar();

        String[] carNames = inputView.getEnterCars().split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
