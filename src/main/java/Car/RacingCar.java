package Car;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final Random random = new Random();

    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public RacingCar(int carCount, String[] carNames) {
        validate(carCount, carNames);

        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(carNames[i]));

        }
    }

    public void gameStart() {
        cars.stream()
                .forEach(car -> car.move(random.nextInt(RANDOM_NUMBER_BOUND)));
    }

    private void validate(int carCount, String[] carNames) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("0보다 큰 값을 입력해주세요.");
        }
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public List<Car> getWinner() {
        Comparator<Car> carComparatorMaxMoveCount = Comparator.comparingInt(Car::getMoveCount);
        int maxMoveCount = cars.stream()
                .max(Comparator.comparingInt(Car::getMoveCount))
                .get()
                .getMoveCount();

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList());
    }
}
