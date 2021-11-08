package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    private Cars(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public static Cars createWithDefaultPosition(MoveStrategy moveStrategy, Names names) {
        List<Car> cars = names.getNames().stream().map(name -> Car.createWithDefaultPosition(moveStrategy, name))
                .collect(Collectors.toList());
        return new Cars(cars, moveStrategy);
    }

    public static Cars create(MoveStrategy moveStrategy, List<Car> cars) {
        return new Cars(cars, moveStrategy);
    }

    public void print() {
        this.cars.stream()
                .forEach(car -> System.out.println(car.carToString()));
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

    public Cars move() {
        List<Car> moveCars = cars.stream().map(Car::moveOrStop)
                .collect(Collectors.toList());

        return create(moveStrategy, moveCars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
