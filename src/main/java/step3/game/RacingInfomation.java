package step3.game;

public class RacingInfomation {
    private final int numberOfCar;
    private final int playCount;

    public RacingInfomation(int numberOfCar, int playCount) {
        this.numberOfCar = numberOfCar;
        this.playCount = playCount;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getPlayCount() {
        return playCount;
    }
}
