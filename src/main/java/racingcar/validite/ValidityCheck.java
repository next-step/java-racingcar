package racingcar.validite;

import java.util.List;

import static racingcar.message.ExceptionMessageEnum.*;

public class ValidityCheck {

    private static final int INPUT_CONDITION_NUMBER = 0;
    private static final int CAR_NAME_LENGTH = 5;

    public static int positiveNumberCheck(int number) {
        try {
            checkNumberSize(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_STRING_INPUT.getMessage());
        }
        return number;
    }

    private static void checkNumberSize(Integer number) {
        if (number < INPUT_CONDITION_NUMBER) {
            throw new IllegalArgumentException(ERROR_INPUT_UNDER_ZERO.getMessage());
        }
    }

    public static List<String> carNameCheck(List<String> carNameList) {
        for (String name : carNameList) {
            carNameLengthCheck(name);
        }
        return carNameList;
    }

    private static String carNameLengthCheck(String name) {
        if (nameLengthBoolean(name)) {
            return name;
        }
        throw new IllegalArgumentException(ERROR_INPUT_CAR_NAME.getMessage());
    }

    private static boolean nameLengthBoolean(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INPUT_CAR_NAME_EMPTY.getMessage());
        }
        if (name.length() > CAR_NAME_LENGTH) {
            return false;
        }
        return true;
    }
}
