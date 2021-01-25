package racingcar.util;

import java.util.Arrays;
import racingcar.Constant;

public class ValidateUtils {

    public boolean validateCarName(String[] cars) {
        if (!isNameSizeValid(cars) || !isNameDistinct(cars)) {
            PrintUtils.printErrorCarName();
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
            .allMatch(car -> car.length() <= Constant.CAR_NAME_SIZE_CONDITION
                && car.length() > Constant.CAR_NAME_SIZE_MIN);
    }

    private boolean isNameDistinct(String[] cars) {
        return Arrays.stream(cars)
            .distinct()
            .count() == cars.length;
    }
}
