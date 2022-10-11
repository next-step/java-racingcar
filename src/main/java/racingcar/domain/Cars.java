package racingcar.domain;

import racingcar.dto.CarResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    private static final int CAR_NAME_THRESHOLD = 5;


    private Cars(List<String> carNames) {
        carNames.forEach(carName -> cars.add(Car.nameOf(carName)));
    }

    public static Cars namesOf(List<String> carNames) {
        validateCarNames(carNames);
        return new Cars(carNames);
    }

    private static void validateCarNames(List<String> carNames) throws IllegalArgumentException {
        if (carNames.stream().anyMatch(Cars::isOverThreshold)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static boolean isOverThreshold(String carName) {
        return carName.length() > CAR_NAME_THRESHOLD;
    }

    public void race(int movableThreshold) {
        cars.forEach(car -> car.moveForward(movableThreshold));
    }

    public List<String> getCarNames() {
        return cars.stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<Integer> getPositions() {
        return cars.stream().map(Car::getPosition).collect(Collectors.toList());
    }
}
