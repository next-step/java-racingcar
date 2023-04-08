package racingcar.domain;

public class InputData {

    private int carCount;
    private int roundCount;

    public InputData(int carCount, int roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
