package racingcar.util;

import java.util.Arrays;

public class InputValidator {

    private InputValidator() {
    }

    static final int CAR_NAME_SIZE_CONDITION = 5;

    public static boolean validateCarName(String[] cars) {
        if (!isNameSizeValid(cars)) {
            System.out.println(Constant.ERROR_CAR_LENGTH);
            return false;
        }
        if (!isNameDistinct(cars)) {
            System.out.println(Constant.ERROR_OVERLAP_CAR_NAME);
            return false;
        }
        return true;
    }

    public static boolean validGameCntInput(String cntInput) {
        try {
            Integer.parseInt(cntInput);
        } catch (NumberFormatException e) {
            System.out.println(Constant.ERROR_TRY_COUNT_NUMBER);
            return false;
        }
        return true;
    }

    private static boolean isNameSizeValid(String[] cars) {
        return Arrays.stream(cars)
            .allMatch(car -> car.length() <= CAR_NAME_SIZE_CONDITION);
    }

    private static boolean isNameDistinct(String[] cars) {
        return Arrays.stream(cars)
            .distinct()
            .count() == cars.length;
    }
}
