package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<RaceTurnResult> raceTurnResults;

    public RacingResult() {
        this.raceTurnResults = new ArrayList<>();
    }

    public List<RaceTurnResult> getRaceTurnResults() {
        return raceTurnResults;
    }
}

