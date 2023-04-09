package game;

public final class CarEngine {

    private static final int MIN = 0;
    private static final int MAX = 9;

    private CarEngine() {
        throw new IllegalCallerException("잘못 된 객체 생성입니다.");
    }

    public static int turn() {
        return RandomNumberGenerator.range()
                .min(MIN)
                .max(MAX)
                .getNumber();
    }
}