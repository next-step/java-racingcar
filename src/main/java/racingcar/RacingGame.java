package racingcar;

import java.util.List;

public class RacingGame {
    private int times;

    public RacingGame(int times) {
        this.times = times;
    }

    public List<Car> start(List<Car> cars, NumberGenerator numberGenerator) {
        for (Car car : cars) {
            race(car, numberGenerator.generateNumbers(times));
        }
        return cars;
    }

    public Car race(Car car, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            car.move(numbers[i]);
        }
        return car;
    }
}
