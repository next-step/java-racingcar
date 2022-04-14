package study.step3;

import study.step3.util.NumberGenerator;

import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play() {
        for (Car car : cars) {
            car.move(NumberGenerator.randomVal(10));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
