package ThirdStep;

import ThirdStep.interfaces.MovingCondition;
import ThirdStep.model.Car;

public class CarAction {
    private static final String LOCATION_SIGN = "-";

    public void move(Car car, MovingCondition movingCondition) {
        if (movingCondition.canMoveForward()) {
            car.setLocation(car.getLocation() + 1);
        }
    }

    public void printLocation(Car car) {
        TextPrinter.print(LOCATION_SIGN.repeat(car.getLocation()));
    }
}
