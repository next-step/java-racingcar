package racingcar;

public class RacingGameOption {

    private int numberOfCar;
    private int numberOfTimes;

    public RacingGameOption(int numberOfCar, int numberOfTimes) {
        this.numberOfCar = numberOfCar;
        this.numberOfTimes = numberOfTimes;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }
}