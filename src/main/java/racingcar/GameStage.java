package racingcar;

import static java.util.stream.IntStream.range;
import static racingcar.utils.IntegerUtils.isPositiveNumber;

import java.util.List;
import java.util.Random;
import racingcar.domain.GameConfig;
import racingcar.domain.GameResult;


public class GameStage {

    private final int maxOfRound;
    private final List<Car> cars;
    private final GameResult result;

    private GameStage(int maxOfRound, Participants participants) {
        this.maxOfRound = isPositiveNumber(maxOfRound);
        this.cars = participants.ready();
        this.result = new GameResult();
    }

    public static GameStage init(GameConfig config) {
        return new GameStage(config.getMaxOfRound(), config.getParticipants());
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
