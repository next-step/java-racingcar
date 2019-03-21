package racing.dto;

import java.util.List;

public class RacingGameRoundResult {
    private List<CarRoundResult> carResults;

    public RacingGameRoundResult(List<CarRoundResult> carResults) {
        this.carResults = carResults;
    }

    public List<CarRoundResult> getCarResults() {
        return this.carResults;
    }
}
