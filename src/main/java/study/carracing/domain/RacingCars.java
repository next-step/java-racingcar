package study.carracing.domain;

import study.carracing.ui.ResultView;

import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(int tryCount) {
        ResultView.printTitle();
        for (int i = 0; i < tryCount; i++) {
            cars.forEach(Car::move);
            ResultView.printResult(cars);
        }
    }
}
