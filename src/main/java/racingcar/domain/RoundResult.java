package racingcar.domain;

import java.util.List;

public class RoundResult {
    private final List<CarStat> carStats;

    public RoundResult(List<CarStat> carStats) {
        this.carStats = carStats;
    }

    public List<CarStat> getCarStats() {
        return carStats;
    }
}
