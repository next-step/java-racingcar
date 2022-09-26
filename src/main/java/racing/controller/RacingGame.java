package racing.controller;

import racing.model.DefaultCar;
import racing.util.RandomGenerator;
import racing.model.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int count;

    public void start() {
        cars = generateCar(InputView.getCarCount());
        count = InputView.getGameCount();

        startRacing();
    }

    private void startRacing() {
        ResultView.printResultTitle();
        for (int i = 0; i < count; i++) {
            racingProcess(cars);
            ResultView.showRacingProcess(cars);
        }
    }

    private void racingProcess(List<Car> cars) {
        for (Car car : cars) {
            CarMoveProcess(car);
        }
    }

    private void CarMoveProcess(Car car) {
        if (car.canMove(RandomGenerator.generate())) {
            car.move();
        }
    }

    public List<Car> generateCar(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new DefaultCar());
        }
        return cars;
    }
}
