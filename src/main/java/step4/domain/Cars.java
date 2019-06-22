package step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차들이 생성되지 않았습니다.");
        }
        this.cars = cars;
    }

    public static Cars of(CarNames carNames) {
        return new Cars(carNames.getCarNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars move() {
        for (Car car : cars) {
            car.move(RandomNumber.generate());
        }
        return new Cars(cars);
    }

    public int findWinnerPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
