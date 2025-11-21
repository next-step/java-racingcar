package racingcar;

import java.util.*;

public class RaceGame {

    private static final int MIN_CAR_COUNT = 1;
    private static final int MAX_RANDOM_VALUE = 10;
    private static final String ERROR_CAR_COUNT = "자동차 대수는 최소 " + MIN_CAR_COUNT + "대 이상이어야 합니다.";
    public static final String ERROR_CAR_NAME_DUPLICATE = "자동차 이름은 중복될 수 없습니다.";

    private final Cars cars;
    private GameCount gameCount;
    private final Random random;


    public RaceGame(List<String> carNames, int gameCount) {
        this(carNames, gameCount, new Random());
    }

    public RaceGame(List<Car> cars, GameCount gameCount) {
        this.cars = Cars.fromCars(cars);
        this.gameCount = gameCount;
        this.random = new Random();
    }

    public RaceGame(List<String> carNames, int gameCount, Random random) {
        List<CarName> validatedNames = validateCarNames(carNames);
        this.cars = new Cars(validatedNames);
        this.gameCount = new GameCount(gameCount);
        this.random = random;
    }

    public Cars cars() {
        return cars;
    }

    public GameCount gameCount() {
        return gameCount;
    }

    public boolean hasNextRound() {
        return gameCount.isPositive();
    }

    public void playRound() {
        cars.moveAll(random);
        gameCount = gameCount.decrease();
    }

    public List<CarName> getWinners() {
        List<CarName> winners = new ArrayList<>();
        Position maxPosition = findMaxPosition(cars.allCars());
        for (Car car : cars.allCars()) {
            addWinnerIfMaxPosition(winners, car, maxPosition);
        }
        return winners;
    }

    private static void addWinnerIfMaxPosition(List<CarName> winners, Car car, Position maxPosition) {
        if (car.isAtSamePositionAs(maxPosition)) {
            winners.add(car.name());
        }
    }

    private List<CarName> validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }

        List<CarName> names = new ArrayList<>();
        for (String name : carNames) {
            names.add(new CarName(name));
        }

        Set<CarName> nameSet = new HashSet<>(names);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATE);
        }
        return names;
    }

    private Position findMaxPosition(List<Car> cars) {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.updateMax(maxPosition);
        }
        return maxPosition;
    }
}