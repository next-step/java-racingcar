package racing.view;

import java.util.List;

public class RacingGameResultView {
    private String winners;
    private List<RacingCarsDto> history;

    public RacingGameResultView(String winners, List<RacingCarsDto> history) {
        this.winners = winners;
        this.history = history;
    }

    public String getWinners() {
        return winners;
    }

    public List<RacingCarsDto> getHistory() {
        return history;
    }

    public RacingCarsDto getFirstHistory() {
        return history.get(0);
    }

    public RacingCarsDto getLastHistory() {
        return history.get(history.size() - 1);
    }

    public static RacingGameResultView toView(String winners, List<RacingCarsDto> history) {
        return new RacingGameResultView(winners, history);
    }
}
