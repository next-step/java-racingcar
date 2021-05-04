package utils;

import utils.exception.CarNameAtLeastOneCommaWhenSplitException;

import java.util.Scanner;

public class InputCarNames {
    public static final String SPLIT = ",";

    public static String[] inCarName() {
        Scanner sc = new Scanner(System.in);
        String inputCarNames = sc.next();
        String[] carNames = StringSplitter.splitBasedOn(inputCarNames, SPLIT);
        validCarNamesSize(carNames);
        return carNames;
    }

    private static void validCarNamesSize(String[] carNames) {
        if (carNames.length <= 1) {
            throw new CarNameAtLeastOneCommaWhenSplitException();
        }
    }
}
