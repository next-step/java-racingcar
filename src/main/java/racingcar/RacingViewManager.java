package racingcar;

public class RacingViewManager {

    private static final String RESULT_COMMENT = "실행 결과";
    private static final String WINNERS_STRING = "가 최종 우승했습니다.";
    private static final int DEFAULT_DISTANCE_COUNT = 1;
    private final RacingManager racingManager;

    public RacingViewManager(RacingManager racingManager) {
        this.racingManager = racingManager;
    }

    public void printResult() {
        System.out.println(RESULT_COMMENT);
        printRecords();
        printWinners();
    }

    private void printRecords() {
        for (RacingRoundRecord racingRoundRecord : racingManager.getRecords()) {
            printCarRecord(racingRoundRecord);
            System.out.println();
        }
    }

    private void printCarRecord(RacingRoundRecord racingRoundRecord) {
        for (CarDto carRecord : racingRoundRecord.getRacingRecord()) {
            System.out.println(carRecord.getName() + " : " + "-".repeat(carRecord.getDistance() + DEFAULT_DISTANCE_COUNT));
        }
    }

    private void printWinners() {
        System.out.println(String.join(",", racingManager.getCars().findWinnerNames()) + WINNERS_STRING);
    }
}
