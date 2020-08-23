package racingcar.domain;

import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.util.List;
import java.util.Objects;

public class Cars {
    private static List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static Cars createCars(List<Car> cars) {
        return new Cars(cars);
    }

    public static void moveCars() {
        List<Car> carsList = cars;
        for (Car car : carsList) {
            car.move(new OneOrZeroForwardCondition(), new DoOneForward());
        }
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
