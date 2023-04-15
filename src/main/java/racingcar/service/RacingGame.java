package racingcar.service;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int moveTimes;

    private List<Car> cars;

    public RacingGame() {
        this.cars = new ArrayList<>();
    }

    public void setCarNumber() {
        int number = InputView.setCarNumber();
        for (int i = 0; i < number; i++) {
            cars.add(new Car(0));
        }
    }

    public void setMoveTimes() {
        moveTimes = InputView.setMoveTimes();
    }

    public void racing() {
        System.out.println("실행결과");

        for (int i = 0; i < moveTimes; i++) {
            moveCars();
            ResultView.printResult(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int getCarNumber() {
        return cars.size();
    }

    public int getMoveTimes() {
        return moveTimes;
    }

}
