package ThirdStep.model;

import ThirdStep.validator.RequestValidator;

public class Car {

    private static final int START_LOCATION = 0;
    private int location;
    private String name;

    public Car() {
        this.location = START_LOCATION;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void move() {
        ++this.location;
    }

    public static Car of(CarRequest carRequest) {
        RequestValidator.carValidation(carRequest);

        Car car = new Car();
        car.setName(carRequest.getName());
        return car;
    }
}
