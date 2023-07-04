package racingcar;

import java.util.List;

public class RacingViewManager {

    private final RacingManager racingManager;

    private static final String RESULT_COMMENT = "실행 결과";
    private static final String WINNERS_STRING = "가 최종 우승했습니다.";
    private static final int DEFAULT_DISTANCE_COUNT = 1;

    public RacingViewManager(RacingManager racingManager) {
        this.racingManager = racingManager;
    }

    public void printResult() {
        System.out.println(RESULT_COMMENT);
        printRecords();
        printWinners();
    }

    private void printRecords() {
        for (List<CarDto> record : racingManager.getRecords()) {
            printCarRecord(record);
            System.out.println();
        }
    }

    private void printCarRecord(List<CarDto> record) {
        for (CarDto carRecord : record) {
            System.out.println(carRecord.getName() + " : " + "-".repeat(carRecord.getDistance() + DEFAULT_DISTANCE_COUNT));
        }
    }

    private void printWinners() {
        System.out.println(String.join(",", racingManager.getCars().findWinnerNames()) + WINNERS_STRING);
    }
}
