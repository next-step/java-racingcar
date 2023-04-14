package racingcar;


import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

    Cars cars;
    InputView inputView;
    ResultView resultView;

    public RacingGame() {
        cars = new Cars();
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void initCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
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
        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfTry = inputView.enterNumberOfTry();
        initCars(numberOfCars);
        move(numberOfTry);
        resultView.printResult(cars);
    }
}
