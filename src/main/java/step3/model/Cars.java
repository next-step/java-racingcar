package step3.model;

import step3.Car;

import java.util.ArrayList;
import java.util.List;

public final class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.accelerate(movingStrategy)); // 모든 자동차 주행
    }
}
