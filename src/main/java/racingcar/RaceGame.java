package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {

    private static final int MIN_CAR_COUNT = 1;
    private static final int MIN_GAME_COUNT = 1;
    private static final int MAX_RANDOM_VALUE = 10;
    private static final String ERROR_CAR_COUNT = "자동차 대수는 최소 " + MIN_CAR_COUNT + "대 이상이어야 합니다.";
    private static final String ERROR_GAME_COUNT = "게임 횟수는 최소 " + MIN_GAME_COUNT + "회 이상이어야 합니다.";

    private final List<Car> cars;
    private final GameCount gameCount;
    private final Random random;

    public RaceGame(List<String> carNames, int gameCount) {
        this(carNames, gameCount, new Random());
    }

    public RaceGame(List<String> carNames, int gameCount, Random random) {
        validateCarNames(carNames);
        this.cars = createCars(carNames);
        this.gameCount = new GameCount(gameCount);
        this.random = random;
    }

    public List<Car> cars() {
        return cars;
    }

    public GameCount gameCount() {
        return gameCount;
    }

    public void playRound() {
        for (Car car : cars) {
            car.moveIfPossible(random.nextInt(MAX_RANDOM_VALUE));
        }
    }

    public List<CarName> getWinners() {
        List<CarName> winners = new ArrayList<>();
        Position maxPos = getMaxPosition(cars);
        for (Car car : cars) {
            addWinnerIfMaxPosition(winners, car, maxPos);
        }
        return winners;
    }

    private static void addWinnerIfMaxPosition(List<CarName> winners, Car car, Position maxPos) {
        if (car.position().equals(maxPos)) {
            winners.add(car.name());
        }
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }
    }

    private void validateGameCount(int gameCount) {
        if (gameCount < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(ERROR_GAME_COUNT);
        }
    }

    private Position getMaxPosition(List<Car> cars) {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            maxPosition = maxPosition.max(car.position());
        }
        return maxPosition;
    }
}