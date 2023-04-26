package step5.dto;

import step5.domain.CarStatus;
import step5.domain.RacingGameResult;

import java.util.List;

public class RoundResult {

    private final List<CarStatus> carStatuses;

    private RoundResult(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public static RoundResult from(RacingGameResult racingGameResult) {
        return new RoundResult(racingGameResult.getCarStatuses());
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }
}
