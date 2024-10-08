package study.racing.domain;

public class Input {
    private int carCount;
    private int roundCount;
    private String[] carNames;

    public Input(int carCount, int roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
    }

    public Input(String[] carNames, int carCount, int roundCount) {
        this.carCount = carCount;
        this.carNames = carNames;
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

    public String[] getCarNames() {
        return carNames;
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }


}
