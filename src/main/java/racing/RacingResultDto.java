package racing;

import java.util.List;

public class RacingResultDto {
    private final List<String> carNames;
    private final List<List<Integer>> playHistory;
    private final List<String> winnerNames;

    public RacingResultDto(List<String> carNames, List<List<Integer>> playHistory, List<String> winnerNames) {
        this.carNames = carNames;
        this.playHistory = playHistory;
        this.winnerNames = winnerNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<List<Integer>> getPlayHistory() {
        return playHistory;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
