package utils;

import utils.exception.CarNameAtLeastOneCommaWhenSplitException;
import utils.exception.CarNameExceedFiveCharacterException;

import java.util.Scanner;

public class InputCarName {
    public static String[] inCarName() {
        Scanner sc = new Scanner(System.in);
        String carNameStr = sc.next();
        String[] carNames = ValidationCarName.splitBasedOnCommas(carNameStr);

        checkCarNameSize(carNames);
        for (String carName : carNames) {
            checkCarNameLength(carName);
        }

        return carNames;
    }

    private static void checkCarNameLength(String carName) {
        if (!ValidationCarName.isCarNameLessThanFiveDigits(carName)) {
            throw new CarNameExceedFiveCharacterException();
        }
    }

    private static void checkCarNameSize(String[] carNames) {
        if (carNames.length <= 1) {
            throw new CarNameAtLeastOneCommaWhenSplitException();
        }
    }
}
