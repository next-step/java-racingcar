package racingcar.domain;

import java.lang.reflect.Array;

public class InputValidator {


    public static boolean checkCarsNameInput(String input) {

        try {
            CheckEachCarsName(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean checkRoundNumberInput(String round) {

        int roundNumber;
        try {
            roundNumber = Integer.parseInt(round);
        } catch (Exception e) {
            System.out.println("올바른 입력이 아닙니다. 정수를 입력해주세요.");
            return false;
        }
        return true;
    }

    private static void CheckEachCarsName(String input) {

        checkInputAllDelimeter(input);
        for (String carName : input.split(",")) {
            checkEmptyInput(carName);
        }
    }

    private static void checkEmptyInput(String carName) {

        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름이 있습니다.");
        }
    }

    private static void checkInputAllDelimeter(String input) {

        String[] carName = input.split(",");
        if (carName.length == 0) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름이 있습니다.");
        }
    }
}
