package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private final String DUPLICATE_CAR_NAME = "중복된 이름을 가진 자동차가 있습니다.";

    public Cars() {
        cars = new ArrayList<>();
    }

    public void add(Car car) {
        if (isDuplicate(car)) throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        cars.add(car);
    }

    private boolean isDuplicate(Car car) {
        return cars.stream().anyMatch(item -> item.getName().equals(car.getName()));
    }

    public int size() {
        return cars.size();
    }

    public void move() {
        cars.forEach(car -> car.move(new CarMovingStrategy()));
    }

    public List<Car> getCars() {
        return cars;
    }

    private int findMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public String findWinner() {
        int maxPosition = findMaxPosition();
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.joining(", "));
    }
}
