package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;
import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static String[] getWinners(RoundResult roundResults) {
        List<DriveResult> driveResults = roundResults.driveResults();
        int maxDistance = getMaxDistance(driveResults);
        return getWinners(driveResults, maxDistance);
    }

    private static int getMaxDistance(List<DriveResult> driveResults) {
        int maxDistance = 0;
        for (DriveResult driveResult : driveResults) {
            maxDistance = Math.max(driveResult.drivenDistance, maxDistance);
        }
        return maxDistance;
    }

    private static String[] getWinners(List<DriveResult> driveResults, int maxDistance) {
        List<String> winners = new ArrayList<>();
        // 이 부분 Stream 사용 안하고 indent 1이 나오게끔 할 수 있는 좋은 방법이 있을까요??
        for (DriveResult driveResult : driveResults) {
            if (driveResult.drivenDistance == maxDistance) {
                winners.add(driveResult.name);
            }
        }
        return winners.toArray(String[]::new);
    }
}
