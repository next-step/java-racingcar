package ThirdStep.model;

import ThirdStep.validator.RequestValidator;

public class Car {
    private final String name;

    public Car(CarRequest carRequest) {
        RequestValidator.carValidation(carRequest);

        this.name = carRequest.getName();
    };

    public String getName() {
        return name;
    }
}
