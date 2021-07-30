package racingcar.step5.domain;

public class Validation {
    private static final int MAX_CAR_LENGTH = 5;
    private static final int MIN_TRY_COUNT = 1;

    public static void checkForNull(String strLiterals) {
        if (strLiterals.isEmpty() || strLiterals == null || strLiterals.equals(" ")) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요 ");
        }
        isValidCarNames(strLiterals);
    }

    public static void isValidCarNames(String strLiterals) {
        String[] carNames = strLiterals.split(",");
        for (String car : carNames) {
            checkValidCarLength(car);
        }
    }


    public static void checkValidCarLength(String car) {
        if (car.length() > MAX_CAR_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자리를 초과할 수 없습니다.");
        }

    }

    public static void checkValidTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 회 수는 1부터 입력 가능합니다");
        }
    }
}
