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

    private List<Integer> playOneRound() {
        List<Integer> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.move(randomNumberGenerator.generateNumber()));
        }
        return result;
    }

    public List<Integer> playGame(int gameCount) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < gameCount; ++i) {
            result = playOneRound();
        }
        return result;
    }
}
