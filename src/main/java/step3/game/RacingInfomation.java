package step3.game;

public class RacingInfomation {
    private final Integer numberOfCar;
    private final Integer playCount;

    public RacingInfomation(Integer numberOfCar, Integer playCount) {
        this.numberOfCar = numberOfCar;
        this.playCount = playCount;
    }

    public Integer getNumberOfCar() {
        return numberOfCar;
    }

    public Integer getPlayCount() {
        return playCount;
    }
}
