package Car;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MAX_SIZE_NAME_LENGTH = 5;
    private static final int MIN_CAR_COUNT = 0;

    private List<Car> cars;

    public RacingCar(String[] carNames) {
        int carCount = carNames.length;
        validate(carCount, carNames);

        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(carNames[i]));

        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void gameStart(Random random, int randomNumberBound) {
        for (Car car : cars) {
            car.move(random.nextInt(RANDOM_NUMBER_BOUND));
        }
    }

    private void validate(int carCount, String[] carNames) {
        if (carCount <= MIN_CAR_COUNT) {
            throw new IllegalArgumentException(MIN_CAR_COUNT + "보다 큰 값을 입력해주세요.");
        }
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_SIZE_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_SIZE_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public List<Car> getWinner() {
        Comparator<Car> carComparatorMaxMoveCount = Comparator.comparingInt(Car::getMoveCount);
        int maxMoveCount = cars.stream()
                .max(Comparator.comparingInt(Car::getMoveCount))
                .orElse(new Car("empty"))
                .getMoveCount();

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList());
    }
}
