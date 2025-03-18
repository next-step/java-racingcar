package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars generateCars(int numOfCars) {
        if(numOfCars < 0 ) {
            throw new RuntimeException("0 이하의 숫자는 입력 불가능 합니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            cars.add(new Car());
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

}
