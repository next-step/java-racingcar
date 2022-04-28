package dto;

import model.CarName;
import model.RoundHistory;

import java.util.List;

public class RacingHistoryDto {
    private final List<CarName> winnerCarNames;
    private final List<RoundHistory> roundHistories;

    public RacingHistoryDto(List<CarName> winnerCarNames, List<RoundHistory> roundHistories) {
        this.winnerCarNames = winnerCarNames;
        this.roundHistories = roundHistories;
    }

    public List<CarName> getWinnerCarNames() {
        return winnerCarNames;
    }

    public List<RoundHistory> getRoundHistories() {
        return roundHistories;
    }
}
