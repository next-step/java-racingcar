package domain;

import domain.dto.RacingResults;
import domain.dto.WinnerResult;

import java.util.List;

public class CarRacingResultDto {
    private final List<WinnerResult> winners;
    private final List<RacingResults> racingResultTotal;

    public CarRacingResultDto(List<WinnerResult> winners, List<RacingResults> racingResultTotal) {
        this.winners = winners;
        this.racingResultTotal = racingResultTotal;
    }

    public List<WinnerResult> getWinners() {
        return winners;
    }

    public List<RacingResults> getRacingResults() {
        return racingResultTotal;
    }
}
