package racingcar.service;

public class ValidationCheck {
    private static final int DEFAULT_CAR_COUNT = 0;

    public static int checkInputCarCount(Integer input) {
        try {
            if (input > DEFAULT_CAR_COUNT) {
                return input;
            }
            throw new IllegalArgumentException("0보다 큰 값으로 입력해주세요.");
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }
}
