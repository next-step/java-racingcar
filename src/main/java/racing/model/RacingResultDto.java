package racing.model;

import java.util.List;

public class RacingResultDto {
    private final List<String> carNames;
    private final PlayHistory playHistory;
    private final List<String> winnerNames;

    public RacingResultDto(List<String> carNames, PlayHistory playHistory, List<String> winnerNames) {
        this.carNames = carNames;
        this.playHistory = playHistory;
        this.winnerNames = winnerNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public PlayHistory getPlayHistory() {
        return playHistory;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
