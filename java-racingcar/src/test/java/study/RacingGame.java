package study;

import ui.ResultView;

import java.util.ArrayList;
import java.util.List;

class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(int numberOfCars, int rounds) {

        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 합니다.");
        }
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }

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


