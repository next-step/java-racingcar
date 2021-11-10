package racingcar;

import static java.util.stream.IntStream.range;
import static racingcar.utils.IntegerUtils.isPositiveNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import racingcar.dto.GameConfig;
import racingcar.dto.GameResult;

public class GameStage {

    private final int maxOfRound;
    private final List<Car> cars = new ArrayList<>();
    private final GameResult result;

    private final Random random = new Random();

    private GameStage(int maxOfRound, int numberOfCars) {
        this.maxOfRound = isPositiveNumber(maxOfRound);

        IntStream.range(0, numberOfCars)
            .forEach(i -> cars.add(new Car()));

        this.result = new GameResult();
    }

    public static GameStage init(GameConfig config) {
        return new GameStage(config.getMaxOfRound(), config.getNumberOfCars());
    }

    public GameResult start() {
        range(0, maxOfRound).forEach(round ->
            range(0, cars.size()).forEach(carPosition -> eachCarAction(round, carPosition)));

        return result;
    }

    private void eachCarAction(int round, int carPosition) {
        Car car = cars.get(carPosition);
        car.action(getRandomValueInRange());
        result.record(round, car.getLocation());
    }

    private int getRandomValueInRange() {
        return random.nextInt(10);
    }
}
