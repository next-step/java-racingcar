package ThirdStep;

import ThirdStep.interfaces.MovingCondition;

public class Car {

    private static final String LOCATION_SIGN = "-";
    private static final int START_LOCATION = 0;
    private int location;
    private String name;

    public Car() {
        this.location = START_LOCATION;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public static Car of(CarRequest carRequest) {
        Car car = new Car();
        car.setName(carRequest.getName());
        return car;
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
