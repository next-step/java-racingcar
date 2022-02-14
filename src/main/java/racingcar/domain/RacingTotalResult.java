package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingTotalResult {

    final static List<RacingResult> racingResults = new ArrayList<>();

    public static List<RacingResult> getRacingResults() {
        return racingResults;
    }

    public static void addResult(RacingResult result) {
        racingResults.add(result);
    }
}
