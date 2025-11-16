package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {

    private static final int MIN_CAR_COUNT = 1;
    private static final int MAX_RANDOM_VALUE = 10;
    private static final String ERROR_CAR_COUNT = "자동차 대수는 최소 " + MIN_CAR_COUNT + "대 이상이어야 합니다.";

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
        Car leadingCar = findLeadingCar(cars);
        for (Car car : cars) {
            addWinnerIfAtLeadingPosition(winners, car, leadingCar);
        }
        return winners;
    }

    private static void addWinnerIfAtLeadingPosition(List<CarName> winners, Car car, Car leadingCar) {
        if (car.isAtSamePositionAs(leadingCar)) {
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

    private Car findLeadingCar(List<Car> cars) {
        Car leadingCar = cars.getFirst();
        for (Car car : cars) {
            leadingCar = compareCar(car, leadingCar);
        }
        return leadingCar;
    }

    private static Car compareCar(Car car, Car leadingCar) {
        if (car.isAheadOf(leadingCar)) {
            return car;
        }
        return leadingCar;
    }
}