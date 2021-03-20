package step4;

public class InputValidator {
    private InputValidator() {}

    public static void checkCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과하였습니다.");
        }
    }

    public static void checkTryCountIsMinus(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수가 잘못되었습니다.");
        }
    }
}
