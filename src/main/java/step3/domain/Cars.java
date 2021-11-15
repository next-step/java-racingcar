package step3.domain;

import step3.service.IntNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String COMMA = ",";

    private List<Car> cars;

    private Cars() {
    }

    private Cars(List<Car> cars) {
        validateIsEmpty(cars);
        this.cars = cars;
    }

    public static Cars create(String names) {
        validateInputIsEmpty(names);
        return new Cars(createCars(names));
    }

    private static List<Car> createCars(String names) {
        return Arrays.stream(splitCarNames(names))
                .map(Car::create)
                .collect(Collectors.toList());
    }

    public Cars move(IntNumberGenerator generator) {
        List<Car> copyList = new ArrayList<>();
        for (Car car : cars) {
            copyList.add(car.move(generator));
        }
        return new Cars(copyList);
    }

    public int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private static String[] splitCarNames(String names) {
        return names.split(COMMA);
    }

    private void validateIsEmpty(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여할 자동차가 존재하지 않습니다.");
        }
    }

    private static void validateInputIsEmpty(String names) {
        if (Objects.isNull(names) || "".equals(names)) {
            throw new IllegalArgumentException("유효하지 않은 입력 값 입니다.");
        }
    }
}
