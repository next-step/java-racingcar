package racing.game.result;

import racing.game.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<RoundResult> roundResults;

    public RacingResult(int numberOfRounds) {
        this.roundResults = new ArrayList<>(numberOfRounds);
        initialize(numberOfRounds);
    }


    public void saveCarRoundResult(Car car, int roundNumber) {
        RoundResult roundResult = roundResults.get(roundNumber);
        roundResult.addCarRoundResult(car);
    }

    public List<RoundResult> roundResults() {
        return roundResults;
    }

    public List<String> winners() {
        RoundResult finalRound = roundResults.get(roundResults.size() - 1);
        return finalRound.nameOfLeadingGroup();
    }


    private void initialize(int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            roundResults.add(new RoundResult());
        }
    }

}
