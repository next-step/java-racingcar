package racingcar;

public class Game {

    private final int carAmount;
    private final int tryAmount;

    public Game(final int carAmount, final int tryAmount) {
        if (carAmount < 1) {
            throw new IllegalArgumentException("자동차 대수는 1 이상이어야 합니다.");
        }
        if (tryAmount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        this.carAmount = carAmount;
        this.tryAmount = tryAmount;
    }

    public int getCarAmount() {
        return carAmount;
    }

    public int getTryAmount() {
        return tryAmount;
    }
}
