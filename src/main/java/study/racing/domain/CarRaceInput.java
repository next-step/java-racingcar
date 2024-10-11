package study.racing.domain;

import java.util.List;

public class CarRaceInput {
    private int carCount;
    private int roundCount;
    private List<String> carNames;

    public CarRaceInput(int carCount, int roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
    }

    public CarRaceInput(List<String> carNames, int carCount, int roundCount) {
        this.carCount = carCount;
        this.carNames = carNames;
        this.roundCount = roundCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }


    public List<String> getCarNames() {
        return carNames;
    }
}
