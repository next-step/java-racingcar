package racingcar;

import java.util.Arrays;

public class InputValidator {

    public boolean validateCarName(String[] cars) {
        if (!isNameSizeValid(cars)) {
            PrintUtils.printErrorCarLength();
            return false;
        }
        if (!isNameDistinct(cars)) {
            PrintUtils.printErrorOverlapCarName();
            return false;
        }
        return true;
    }

    public boolean validGameCntInput(String cntInput) {
        try {
            Integer.parseInt(cntInput);
        } catch (NumberFormatException e) {
            PrintUtils.printErrorTryCountNumber();
            return false;
        }
        return true;
    }

    private boolean isNameSizeValid(String[] cars) {
        return Arrays.stream(cars)
            .allMatch(car -> car.length() <= CAR_NAME_SIZE_CONDITION);
    }

    private boolean isNameDistinct(String[] cars) {
        return Arrays.stream(cars)
            .distinct()
            .count() == cars.length;
    }
}
