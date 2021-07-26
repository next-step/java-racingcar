package racingcar.step4;

import java.util.InputMismatchException;

public class Validation {
    private static final int MAX_CAR_LENGTH = 5;

    public static void checkForNull(String strLiterals) {
        if (strLiterals.isEmpty() || strLiterals == null || strLiterals.equals(" ")) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요 ");
        }

        isValidCarNames(strLiterals);

    }

    public static void isValidCarNames(String strLiterals) {
        String[] carNames = strLiterals.split(",");
        for (String car : carNames) {
            checkCarLength(car);
        }
    }


    public static void checkCarLength(String car) {
        if (car.length() > MAX_CAR_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자리를 초과할 수 없습니다.");
        }

    }

    public static void isValidInteger(int tryCount){
        throw new InputMismatchException();
    }
}
