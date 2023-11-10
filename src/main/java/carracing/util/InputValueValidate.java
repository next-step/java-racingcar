package carracing.util;

public class InputValueValidate {

    private static final int MAX_CAR_NAME_STANDARD = 5;
    private static final String SPLIT_STANDARD = ",";

    private InputValueValidate() {}

    public static String verifyExceedFiveCarName(String carName) {
        if (carName.length() >= MAX_CAR_NAME_STANDARD) {
            throw new RuntimeException();
        }
        return carName;
    }

    public static String[] splitCommaInputCarName(String inputName) {
        return inputName.split(SPLIT_STANDARD);
    }

}
