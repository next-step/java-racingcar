package cc.oakk.racing.model;

import cc.oakk.racing.model.predicate.CarForwardCondition;
import cc.oakk.racing.view.printer.Printable;
import cc.oakk.racing.view.printer.Printer;

public class Car implements Printable<Car>, Comparable<Car> {
    private static final String NO_NAME = "no-name";

    private final String name;
    private final CarForwardCondition<?> carForwardCondition;

    private int movedDistance;

    public Car(CarForwardCondition<?> carForwardCondition) {
        this(NO_NAME, carForwardCondition);
    }

    public Car(String name, CarForwardCondition<?> carForwardCondition) {
        this.name = name;
        this.carForwardCondition = carForwardCondition;
    }

    public void tryMoveForward() {
        if (carForwardCondition.isCarFowardable(this)) {
            moveForward();
        }
    }

    private void moveForward() {
        movedDistance++;
    }

    public String getName() {
        return name;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    @Override
    public void print(Printer<Car> printer) {
        printer.print(this);
    }

    @Override
    public int compareTo(Car target) {
        int targetDistance = target.getMovedDistance();
        return movedDistance - targetDistance;
    }
}
