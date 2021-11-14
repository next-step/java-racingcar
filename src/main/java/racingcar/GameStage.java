package racingcar;

import static java.util.stream.IntStream.range;
import static racingcar.utils.IntegerUtils.isPositiveNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.dto.GameConfig;
import racingcar.dto.GameResult;

public class GameStage {

    private final int maxOfRound;
    private final List<Car> cars = new ArrayList<>();
    private final GameResult result;

    private GameStage(int maxOfRound, List<String> joinOfCarNames) {
        this.maxOfRound = isPositiveNumber(maxOfRound);

        joinOfCarNames
            .forEach(name -> cars.add(Car.create(name)));

        this.result = new GameResult();
    }

    public static GameStage init(GameConfig config) {
        return new GameStage(config.getMaxOfRound(), config.getJoinCarNames());
    }

    public GameResult start() {
        range(0, maxOfRound).forEach(round ->
            range(0, cars.size()).forEach(carPosition -> eachCarAction(round, carPosition)));

        return result;
    }

    private void eachCarAction(int round, int carPosition) {
        Car car = cars.get(carPosition);
        car.action(new Random());
        result.record(round, car);
    }

}
