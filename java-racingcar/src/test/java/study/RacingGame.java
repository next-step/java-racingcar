package study;

import UI.ResultView;

import java.util.ArrayList;
import java.util.List;

class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(int numberOfCars, int rounds) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            race();
            ResultView.printRoundResult(cars);
        }
    }

    private void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}


