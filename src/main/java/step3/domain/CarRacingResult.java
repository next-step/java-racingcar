package step3.domain;

import java.util.List;

public class CarRacingResult {
    private final List<CarRoundResult> carRoundResults;
    private final Winner winner;

    public CarRacingResult(List<CarRoundResult> carRoundResults, Winner winner) {
        this.carRoundResults = carRoundResults;
        this.winner = winner;
    }

    public List<CarRoundResult> getCarRoundResults() {
        return carRoundResults;
    }

    public Winner getWinner() {
        return winner;
    }
}
