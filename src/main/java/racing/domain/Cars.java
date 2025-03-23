package racing.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final List<Car> cars;

    public Cars(final String[] carNames) {
        validateCarNames(carNames);
        this.cars = initializeCars(carNames);
    }

    private void validateCarNames(final String[] carNames) {
        if (hasNameExceedingMaxLength(carNames)) {
            String MESSAGE_FORMAT = "자동차의 이름은 %d자를 초과할 수 없습니다.";
            throw new IllegalArgumentException(String.format(MESSAGE_FORMAT, MAX_CAR_NAME_LENGTH));
        }
    }

    private boolean hasNameExceedingMaxLength(final String[] carNames) {
        return Arrays.stream(carNames).anyMatch(name -> name.length() > MAX_CAR_NAME_LENGTH);
    }

    private List<Car> initializeCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getAll() {
        return cars;
    }

    public List<Car> getWinners() {
        if (cars.isEmpty()) {
            return Collections.emptyList();
        }

        int maxPosition = findMaxPosition();
        return findCarsAtPosition(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> findCarsAtPosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }
}
