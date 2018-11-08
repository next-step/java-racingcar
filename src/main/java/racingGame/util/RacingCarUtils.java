package racingGame.util;

import racingGame.model.RacingCarDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarUtils {
    public static int getHighestPosition(List<RacingCarDTO> snapshots) {
        return Collections.max(extractCarPositions(snapshots));
    }

    public static List<String> extractCarNames(List<RacingCarDTO> snapshots) {
        return snapshots.stream().map(snapshot -> snapshot.getName()).collect(Collectors.toList());
    }

    public static List<Integer> extractCarPositions(List<RacingCarDTO> snapshots) {
        return snapshots.stream().map(snapshot -> snapshot.getPosition()).collect(Collectors.toList());
    }

    public static List<RacingCarDTO> filterRacingCar(List<RacingCarDTO> snapshots, int position) {
        return snapshots.stream().filter(snapshot -> snapshot.isMatchPosition(position)).collect(Collectors.toList());
    }
}
