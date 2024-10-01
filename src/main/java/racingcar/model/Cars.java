package racingcar.model;

import racingcar.util.NumberCreator;

import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
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

    public void moveAllByNumberCreator(NumberCreator numberCreator) {
        this.cars
                .forEach(car -> car.move(numberCreator));
    }

    public List<Car> currentCars() {
        return this.cars;
    }

}
