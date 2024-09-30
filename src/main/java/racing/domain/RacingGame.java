package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;

public class RacingGame {

    private final int roundCount;

    private final List<Car> cars;

    private final NumberGenerator numberGenerator;

    private RacingGame(int roundCount, List<Car> cars) {
        this.roundCount = roundCount;
        this.cars = cars;
        this.numberGenerator = new RandomNumberGenerator();
    }

    public int getRoundCount() {
        return roundCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<GameResult> start() {
        List<GameResult> result = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            int[] resultArray = new int[cars.size()];
            int index = 0;
            for (Car car : cars) {
                car.move(numberGenerator);
                resultArray[index] = car.getCurrentPosition();
                index++;
            }
            result.add(GameResult.save(resultArray));
        }
        return result;
    }

    public static RacingGame setUp(int roundCount, int carCount) {
        return new RacingGame(roundCount, initialCars(carCount));
    }

    private static List<Car> initialCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.create());
        }
        return cars;
    }
}
