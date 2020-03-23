package utils;

import domain.RacingCarPosition;
import domain.RacingRound;

import java.util.ArrayList;
import java.util.List;

public class RacingRoundTestUtil {
    public static RacingRound makeRacingRoundTestCases(String[] carNames, int[] locationPoints) {
        List<RacingCarPosition> racingCarPositions = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            racingCarPositions.add(new RacingCarPosition(carNames[i], locationPoints[i]));
        }
        return RacingRound.newInstance(racingCarPositions);
    }
}
