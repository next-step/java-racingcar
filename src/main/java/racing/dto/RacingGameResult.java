package racing.dto;

import racing.utils.EmptyCheckUtil;

import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private final List<CarRaceResult> carRaceResults;

    public RacingGameResult(List<CarRaceResult> carRaceResults) {
        EmptyCheckUtil.emptyCheck(carRaceResults);
        this.carRaceResults = Collections.unmodifiableList(carRaceResults);
    }

    public String getCarName(int index) {
        return carRaceResults.get(index).getCarName();
    }

    public int getCarPosition(int index) {
        return carRaceResults.get(index).getPosition();
    }

    public int getCarRaceResultSize() {
        return this.carRaceResults.size();
    }
}
