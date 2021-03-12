package racing.dto;

import java.util.ArrayList;
import java.util.List;
import racing.domain.ReadonlyCar;

public class RacingReport {

    private final List<RoundResult> roundResults = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();

    public void saveRoundResult(List<? extends ReadonlyCar> carList) {
        roundResults.add(new RoundResult(carList));
    }

    public List<RoundResult> getRoundResults() {
        return new ArrayList<>(roundResults);
    }

    public void addWinner(String name) {
        winners.add(name);
    }

    public List<String> getWinners() {
        return new ArrayList<>(winners);
    }
}
