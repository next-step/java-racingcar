package racingcar;

public class RacingViewManager {

    private static final int DEFAULT_DISTANCE_COUNT = 1;

    private final RacingManager racingManager;

    public RacingViewManager(RacingManager racingManager) {
        this.racingManager = racingManager;
    }

    public void printResult() {
        System.out.println("실행 결과");
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
        for (CarRecord carRecord : racingRoundRecord.getRacingRecord()) {
            System.out.println(carRecord.getName() + " : " + "-".repeat(carRecord.getDistance() + DEFAULT_DISTANCE_COUNT));
        }
    }

    private void printWinners() {
        System.out.println(String.join(",", racingManager.getWinnerCarNames()) + "가 최종 우승했습니다.");
    }
}
