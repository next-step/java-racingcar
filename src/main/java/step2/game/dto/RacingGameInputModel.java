package step2.game.dto;

public class RacingGameInputModel {
    private final int numberOfCar;
    private final int times;

    public RacingGameInputModel(int numberOfCar, int times) {
        this.numberOfCar = numberOfCar;
        this.times = times;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getTimes() {
        return times;
    }

}
