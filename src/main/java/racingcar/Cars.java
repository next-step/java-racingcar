package racingcar;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getSize() {
        return this.cars.size();
    }

    public Car getCar(int index) {
        return this.cars.get(index);
    }

    public Cars moveAll(MovingStrategy strategy) {
        for (Car car: this.cars) {
            car.move(strategy);
        }
        return this;
    }
}
