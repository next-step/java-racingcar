package game;

public class RacingOptions {
    private final int carCount;
    private final int racingRep;

    public RacingOptions(int carCount, int racingRep) {
        throwIfNegativeNumber(carCount);
        throwIfNegativeNumber(racingRep);

        this.carCount = carCount;
        this.racingRep = racingRep;
    }

    private void throwIfNegativeNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력은 0 보다 큰 양수만 가능합니다.");
        }
    }

    public int racingRep() {
        return racingRep;
    }

    public int carCount() {
        return carCount;
    }
}