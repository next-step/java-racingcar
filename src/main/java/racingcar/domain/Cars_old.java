package racingcar.domain;

import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.util.List;
import java.util.Objects;

public class Cars_old {
    private static List<Car_old> cars;

    public Cars_old(List<Car_old> cars) {
        this.cars = cars;
    }

    public List<Car_old> getCars() {
        return cars;
    }

    public static Cars_old createCars(List<Car_old> cars) {
        return new Cars_old(cars);
    }

    public static void moveCars() {
        List<Car_old> carsList = cars;
        for (Car_old car : carsList) {
            car.move(new OneOrZeroForwardCondition(), new DoOneForward());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Cars_old carsOld1 = (Cars_old) o;
        return Objects.equals(cars, carsOld1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
