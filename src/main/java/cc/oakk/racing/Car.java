package cc.oakk.racing;

import cc.oakk.racing.predicate.CarForwardCondition;
import cc.oakk.racing.printer.Printable;
import cc.oakk.racing.printer.Printer;

public class Car implements Printable<Car>, Comparable<Car> {
    private final String name;
    private final CarForwardCondition<?> carForwardCondition;

    private int movedDistance;

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

        if (movedDistance == targetDistance) {
            return 0;
        }
        return movedDistance > targetDistance ? 1 : -1;
    }
}
