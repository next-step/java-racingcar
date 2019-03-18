package racing;

import java.util.List;

public class RacingGameRoundResult {
    private List<CarRoundResult> carResults;

    RacingGameRoundResult(List<CarRoundResult> carResults) {
        this.carResults = carResults;
    }

    public List<CarRoundResult> getCarResults() {
        return this.carResults;
    }
}
