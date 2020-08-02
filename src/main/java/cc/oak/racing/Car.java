package cc.oak.racing;

import cc.oak.racing.condition.CarForwardCondition;
import cc.oak.racing.printer.Printable;
import cc.oak.racing.printer.Printer;

public class Car implements Printable<Car> {
    private int movedDistance;
    private final CarForwardCondition<?> carForwardCondition;

    public Car(CarForwardCondition<?> carForwardCondition) {
        this.carForwardCondition = carForwardCondition;
    }

    public void tryMoveForward() {
        if (carForwardCondition.isConvertedCarMeetCondition(this)) {
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
