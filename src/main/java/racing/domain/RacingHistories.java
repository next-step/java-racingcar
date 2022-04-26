package racing.domain;

import java.util.List;

public class RacingHistories {
    private final List<String> winners;
    private final List<RoundHistory> roundHistories;

    public RacingHistories(List<String> winners, List<RoundHistory> roundHistories) {
        this.winners = winners;
        this.roundHistories = roundHistories;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<RoundHistory> getRoundHistories() {
        return roundHistories;
    }
}
