package racingcar.view;

import racingcar.domain.CarRecord;
import racingcar.domain.RacingManager;
import racingcar.domain.RacingRecord;
import racingcar.domain.RacingRoundRecord;

import java.util.List;

public class RacingView {

    private static final int DEFAULT_DISTANCE_COUNT = 1;

    public void printResult(RacingManager racingManager) {
        System.out.println("실행 결과");
        printRecords(racingManager.getRacingRecord());
        printWinners(racingManager.getWinnerCarNames());
    }

    private void printRecords(RacingRecord racingRecord) {
        for (RacingRoundRecord racingRoundRecord : racingRecord.getRacingRoundRecords()) {
            printCarRecord(racingRoundRecord);
            System.out.println();
        }
    }

    private void printCarRecord(RacingRoundRecord racingRoundRecord) {
        for (CarRecord carRecord : racingRoundRecord.getRacingRecord()) {
            System.out.println(carRecord.getName() + " : " + "-".repeat(carRecord.getDistance() + DEFAULT_DISTANCE_COUNT));
        }
    }

    private void printWinners(List<String> winnerCarNames) {
        System.out.println(String.join(",", winnerCarNames) + "가 최종 우승했습니다.");
    }
}
