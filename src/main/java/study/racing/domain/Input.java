package study.racing.domain;

public class Input {
    private int carCount;
    private int roundCount;

    public Input(int carCount, int roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }
}
