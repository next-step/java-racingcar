package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private List<Car> cars = new ArrayList<>();
    private RandomNumberGenerator randomNumberGenerator;

    public CarRacingGame(int numCar, long seed) {
        for (int i = 0; i < numCar; i++) {
            cars.add(new Car());
        }
        randomNumberGenerator = new RandomNumberGenerator(seed);
    }

    public List<String> playOneRound() {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateNumber());
            result.add(car.getDistanceString());
        }
        return result;
    }

    public List<List<String>> playGame(int gameCount) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < gameCount; ++i) {
            result.add(playOneRound());
        }
        return result;
    }
}
