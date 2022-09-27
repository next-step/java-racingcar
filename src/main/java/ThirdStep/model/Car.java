package ThirdStep.model;

import ThirdStep.validator.RequestValidator;

public class Car {
    private String name;

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Car of(CarRequest carRequest) {
        RequestValidator.carValidation(carRequest);

        Car car = new Car();
        car.setName(carRequest.getName());
        return car;
    }
}
