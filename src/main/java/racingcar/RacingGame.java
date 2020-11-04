package racingcar;

public class RacingGame {
    private CarGroup carGroup;
    private int currTry;
    private int maxTry;

    public RacingGame(CarGroup carGroup, int tryNum) {
        this.carGroup = carGroup;

        this.currTry = 0;
        this.maxTry = tryNum;
    }

    public boolean checkNotGameOver() {
        return this.currTry < this.maxTry;
    }

    public void play() {
        if (!this.checkNotGameOver()) {
            return;
        }
        this.currTry++;
        this.carGroup.moveCar();
    }
}
