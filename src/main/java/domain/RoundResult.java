package domain;

import java.util.List;

public class RoundResult {
    Integer roundNumber;
    List<CarResult> carResults;

    public RoundResult(Integer roundNumber, List<CarResult> carResults) {
        this.roundNumber = roundNumber;
        this.carResults = carResults;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public List<CarResult> getCarResults() {
        return carResults;
    }
}
