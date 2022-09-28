package ThirdStep.domain.model;

import ThirdStep.domain.model.request.CarRequest;
import ThirdStep.domain.validator.RequestValidator;

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
