package racing.model;

import java.util.List;

public class RacingResultDto {
    private final PlayHistory playHistory;
    private final List<String> winnerNames;

    public RacingResultDto(PlayHistory playHistory,
            List<String> winnerNames) {
        this.playHistory = playHistory;
        this.winnerNames = winnerNames;
    }

    public PlayHistory getPlayHistory() {
        return playHistory;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
