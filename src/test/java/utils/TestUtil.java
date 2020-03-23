package utils;

import domain.RacingCarPosition;
import domain.RacingRound;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {
    public static RacingRound makeRacingRoundTestCases(String[] carNames, Integer[] locationPoints) {
        List<RacingCarPosition> racingCarPositions = makeRacingCarPositionsTestCases(carNames, locationPoints);
        return RacingRound.newInstance(racingCarPositions);
    }

    public static List<RacingCarPosition> makeRacingCarPositionsTestCases(String[] carNames, Integer[] locationPoints) {
        List<RacingCarPosition> racingCarPositions = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            racingCarPositions.add(makeRacingCarPositionTestCases(carNames[i], locationPoints[i]));
        }
        return racingCarPositions;
    }

    private static RacingCarPosition makeRacingCarPositionTestCases(String carName, Integer locationPoint) {
        return RacingCarPosition.newInstance(carName, locationPoint);
    }
}
