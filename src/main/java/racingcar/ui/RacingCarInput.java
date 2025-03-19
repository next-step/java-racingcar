package racingcar.ui;

public class RacingCarInput {

    private final int carCount;
    private final int tryCount;

    public RacingCarInput(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        this.validate();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validate() {
        if (this.carCount < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }

        if (this.tryCount < 2) {
            throw new IllegalArgumentException("시도 횟수는 2 이상이어야 합니다.");
        }
    }
}
