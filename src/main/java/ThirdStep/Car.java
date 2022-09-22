package ThirdStep;

import ThirdStep.interfaces.MovingCondition;

public class Car {

    private static final String LOCATION_SIGN = "-";
    private static final int START_LOCATION = 0;
    private int location;

    public Car() {
        this.location = START_LOCATION;
    }

    public int getLocation() {
        return location;
    }

    public void move(MovingCondition movingCondition) {
        if (movingCondition.canMoveForward()) {
            ++location;
        }
    }

    public void printLocation() {
        TextPrinter.print(LOCATION_SIGN.repeat(location));
    }
}
