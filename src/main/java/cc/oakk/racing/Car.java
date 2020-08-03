package cc.oakk.racing;

import cc.oakk.racing.predicate.CarForwardCondition;
import cc.oakk.racing.printer.Printable;
import cc.oakk.racing.printer.Printer;

public class Car implements Printable<Car> {
    private int movedDistance;
    private final CarForwardCondition<?> carForwardCondition;

    public Car(CarForwardCondition<?> carForwardCondition) {
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

    public int getMovedDistance() {
        return movedDistance;
    }

    @Override
    public void print(Printer<Car> printer) {
        printer.print(this);
    }
}
