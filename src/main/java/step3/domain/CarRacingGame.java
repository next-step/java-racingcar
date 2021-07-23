package step3.domain;

public class CarRacingGame {

    private final int carCount;
    private final int tryCount;


    public CarRacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }


    @Override
    public String toString() {
        return String.format("(자동차 게임) 자동차수: %d, 시도회수: %d", this.carCount, this.tryCount);
    }
}
