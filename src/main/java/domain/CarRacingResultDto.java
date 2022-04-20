package domain;

import java.util.List;
import java.util.Map;

public class CarRacingResultDto {
    private final List<Car> winners;
    private final List<Map<String, Integer>> racingResults;

    public CarRacingResultDto(List<Car> winners, List<Map<String, Integer>> racingResults) {
        this.winners = winners;
        this.racingResults = racingResults;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public List<Map<String, Integer>> getRacingResults() {
        return racingResults;
    }
}
