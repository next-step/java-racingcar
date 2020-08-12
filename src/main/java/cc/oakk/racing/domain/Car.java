package cc.oakk.racing.domain;

import cc.oakk.racing.domain.predicate.CarForwardCondition;
import cc.oakk.racing.view.printer.Printable;
import cc.oakk.racing.view.printer.Printer;

import java.util.Objects;

public class Car implements Printable<Car>, Comparable<Car> {
    private static final String NO_NAME = "no-name";

    private final CarName name;
    private final CarForwardCondition<?> carForwardCondition;

    private final Position movedDistance = new Position(0);

    public Car(CarForwardCondition<?> carForwardCondition) {
        this(NO_NAME, carForwardCondition);
    }

    public Car(String name, CarForwardCondition<?> carForwardCondition) {
        this.name = new CarName(name);
        this.carForwardCondition = carForwardCondition;
    }

    public void tryMoveForward() {
        if (carForwardCondition.isCarFowardable(this)) {
            movedDistance.increase();
        }
    }

    public CarName getName() {
        return name;
    }

    public Position getMovedDistance() {
        return movedDistance;
    }

    @Override
    public void print(Printer<Car> printer) {
        printer.print(this);
    }

    @Override
    public int compareTo(Car target) {
        return this.movedDistance.compareTo(target.movedDistance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(carForwardCondition, car.carForwardCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carForwardCondition);
    }
}
