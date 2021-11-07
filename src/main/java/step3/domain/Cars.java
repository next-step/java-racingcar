package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        validateIsEmpty(cars);
        this.cars = cars;
    }

    public static Cars join(List<Car> cars) {
        return new Cars(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void showPosition() {
        for (Car car : cars) {
            car.showPositionToDash();
        }
    }

    private void validateIsEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여할 자동차가 존재하지 않습니다.");
        }
    }
}
