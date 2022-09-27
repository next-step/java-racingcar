package ThirdStep.validator;

import ThirdStep.model.CarRequest;

public class RequestValidator {

    public static final int NAME_LENGTH = 5;

    public static void carValidation(CarRequest carRequest) {
        if (!carNameLengthValidation(carRequest.getName())) {
            throw new RuntimeException();
        }
    }

    private static boolean carNameLengthValidation(String carName) {
        return carName.length() <= NAME_LENGTH;
    }
}
