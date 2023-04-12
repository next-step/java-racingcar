package racingcar;

public class InputView {

    private static final int LOW_LIMIT_COUNT = 1;

    private InputView() {
    }

    public static void printCarInputGuideMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void validateCarAmount(int carAmount) {
        if (carAmount < LOW_LIMIT_COUNT) {
            throw new IllegalArgumentException("자동차 대수는 1 이상이어야 합니다.");
        }
    }

    public static void printTryInputGuideMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void validateTryAmount(int tryAmount) {
        if (tryAmount < LOW_LIMIT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
