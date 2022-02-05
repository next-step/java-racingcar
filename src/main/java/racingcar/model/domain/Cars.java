package racingcar.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String MAX_DRIVE_LENGTH = "MAX 값을 구할 수 없습니다. 비교할 수 있는 정수값인지 확인하세요";
    private final List<Car> cars;

    public Cars(final List<String> userInput) {
        List<Car> cars = new ArrayList<>(run(userInput));
        this.cars = cars;
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void carsDrive(final CarMoveBehavior carMoveBehavior) {
        cars.forEach(car -> carState(car, carMoveBehavior));
    }

    public List<Car> carMaxCheck(final int max) {
        return cars.stream()
            .filter(car -> car.isMax(max))
            .collect(Collectors.toList());
    }

    public int carMaxDistanceCount() {
        return cars.stream().map(Car::getStep)
            .mapToInt(Integer::valueOf)
            .max()
            .orElseThrow(() -> new IllegalArgumentException(MAX_DRIVE_LENGTH));
    }

    private void carState(final Car car, final CarMoveBehavior carMoveBehavior) {
        if (carMoveBehavior.moveBehavior()) {
            car.moveForward();
        }
    }

    private List<Car> run(final List<String> input) {
        ArrayList<Car> cars = new ArrayList<>();
        input.forEach(carName -> cars.add(new Car(carName)));
        return cars;
    }
}

