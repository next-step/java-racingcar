package racingcar.domain;

import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        cars.forEach(car
                -> car.move(new OneOrZeroForwardCondition( ), new DoOneForward( )));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
