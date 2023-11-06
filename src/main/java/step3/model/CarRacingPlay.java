package step3.model;

import java.util.ArrayList;
import java.util.List;

public class CarRacingPlay {

    private final int racingRound;

    private final List<Car> cars = new ArrayList<>();

    private final RandomValueGenerator randomValueGenerator;

    public CarRacingPlay(RandomValueGenerator randomValueGenerator, int attendCarNumber, int racingRound) {
        this.randomValueGenerator = randomValueGenerator;
        this.racingRound = racingRound;
        initializeRacingCars(attendCarNumber);
    }

    public List<Car> raceOneCycle() {
        for (Car car : cars) {
            int randomValue = randomValueGenerator.generateRandomValue();
            car.go(randomValue);
        }
        return cars;
    }

    private void initializeRacingCars(int attendCarNumber) {
        for (int i = 0; i < attendCarNumber; i++) {
            cars.add(Car.makeCar());
        }
    }
}
