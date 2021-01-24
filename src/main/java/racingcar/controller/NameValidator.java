package racingcar.controller;

import java.util.ArrayList;

public class NameValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static Boolean checkCarName(ArrayList<String> carNames) {
        return carNames.stream().allMatch(name -> name.length() <= MAX_CAR_NAME_LENGTH);
    }
}
