package Car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCar {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MAX_SIZE_NAME_LENGTH = 5;
    private static final int MIN_CAR_COUNT = 0;

    private List<Car> cars;

    public RacingCar(String[] carNames) {
        validateCarsSize(carNames);
        cars = Arrays.stream(carNames)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void gameStart(Random random, int randomNumberBound) {
        for (Car car : cars) {
            car.move(random.nextInt(RANDOM_NUMBER_BOUND));
        }
    }

    private void validateCarsSize(String[] carNames) {
        if (carNames.length <= MIN_CAR_COUNT) {
            throw new IllegalArgumentException(MIN_CAR_COUNT + "보다 큰 값을 입력해주세요.");
        }
    }

    public List<Car> getWinner() {
        Comparator<Car> carComparatorMaxMoveCount = Comparator.comparingInt(Car::getMoveCount);
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList());
    }
}
