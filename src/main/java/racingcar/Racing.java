package racingcar;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Racing {

    private final Cars cars;
    private int racingTime;

    Racing() {
        cars = new Cars();
    }

    public void start() {
        prepareRacing();
        startRacing();
    }

    private void prepareRacing() {
        InputView view = new InputView();
        int numberOfCar = view.inputNumberOfCar();
        cars.setCars(numberOfCar);
        racingTime = view.inputNumberOfGame();
    }

    private void startRacing() {
        ResultView.printResultTitle();
        for (int i = 0; i < racingTime; i++) {
            movePosition(cars);
        }
    }

    private void movePosition(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move();
        }
        System.out.println();
    }

}
