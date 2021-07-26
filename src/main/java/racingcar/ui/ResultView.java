package racingcar.ui;

import racingcar.RacingRecord;

import java.util.List;

public class ResultView {

    private static final String RESULT_PRE_MESSAGE = "실행결과\n";
    private static final String RACING_DISPLAY = "-";

    private ResultView() {
    }

    public static void showRacingInfo(List<List<RacingRecord>> racingHistory) {
        System.out.print(RESULT_PRE_MESSAGE);
        for (List<RacingRecord> records : racingHistory) {
            for (RacingRecord record : records) {
                System.out.print(record.getCar().getName() + " : ");
                for (int i = 0; i < record.getPosition(); i++) {
                    System.out.print(RACING_DISPLAY);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
