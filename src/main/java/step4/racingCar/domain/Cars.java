package step4.racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            if (name.length() > 6) {
                throw new RuntimeException("자동차의 이름은 5글자를 초과 할 수 없습니다.");
            }
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        for (Car car: cars) {
            car.move();
        }
    }

}
