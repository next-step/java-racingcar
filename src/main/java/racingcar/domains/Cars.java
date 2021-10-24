package racingcar.domains;

import racingcar.strategies.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;


    public Cars() {
        cars = new ArrayList<>();
    }


    public void add(Car car) {
        cars.add(car);
    }


    public Cars move(MoveStrategy moveStrategy) {
        for (Car car: cars) {
            car.move(moveStrategy);
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
