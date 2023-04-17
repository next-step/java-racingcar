package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;

public class RacingGame {

    Cars cars;
    InputView inputView;
    ResultView resultView;

    public RacingGame() {
        cars = new Cars();
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void initCars(String names) {
        Arrays.stream(names.split(",")).forEach((name) -> {
            cars.add(new Car(name));
        });
    }

    public void move(int numberOfTry) {
        for (int i = 0; i < numberOfTry; i++) {
            cars.move();
        }
    }

    public Cars getCars() {
        return cars;
    }

    public void start() {
        String nameOfCars = inputView.enterNameOfCars();
        int numberOfTry = inputView.enterNumberOfTry();
        initCars(nameOfCars);
        move(numberOfTry);
        resultView.printResult(cars);
    }
}
