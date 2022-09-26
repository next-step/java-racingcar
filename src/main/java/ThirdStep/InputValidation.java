package ThirdStep;

public class InputValidation {

    public static final int NAME_LENGTH = 5;

    public static void carValidation(CarRequest carRequest) {
        if (!carNameLengthValidation(carRequest.getName())) {
            throw new RuntimeException();
        }
    }

    public static boolean carNameLengthValidation(String carName) {
        return carName.length() <= NAME_LENGTH;
    }
}
