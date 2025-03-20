package step4.racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars generateCars(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new RuntimeException("적어도 하나의 자동차를 입력해야 합니다.");
        }
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> winners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = findWinners(maxPosition);

        if (winners.isEmpty()) {
            throw new RuntimeException("우승자가 존재하지 않습니다.");
        }

        return winners;
    }

    private List<Car> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new RuntimeException("자동차가 존재하지 않습니다."));
    }
}
