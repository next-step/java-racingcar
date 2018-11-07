package racingGame.util;

import racingGame.model.RacingCarVO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static int getHighestPosition(List<RacingCarVO> snapshots) {
        return Collections.max(extractCarPositions(snapshots));
    }

    public static List<String> extractCarNames(List<RacingCarVO> snapshots) {
        return snapshots.stream().map(snapshot -> snapshot.getName()).collect(Collectors.toList());
    }

    public static List<Integer> extractCarPositions(List<RacingCarVO> snapshots) {
        return snapshots.stream().map(snapshot -> snapshot.getPosition()).collect(Collectors.toList());
    }

    public static List<RacingCarVO> filterRacingCar(List<RacingCarVO> snapshots, int position) {
        return snapshots.stream().filter(snapshot -> snapshot.getPosition() == position).collect(Collectors.toList());
    }
}
