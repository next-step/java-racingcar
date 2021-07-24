package racingcar.ui;

import racingcar.RacingRecord;

import java.util.ArrayList;

public class ResultView {

    private static final String RESULT_PRE_MESSAGE = "실행결과\n";
    private static final String RACING_DISPLAY = "-";

    private ResultView() {
    }

    public static void showRacingInfo(ArrayList<ArrayList<RacingRecord>> racingHistory) {
        System.out.println(RESULT_PRE_MESSAGE);
        for (ArrayList<RacingRecord> records : racingHistory) {
            System.out.println("=========================");
            for (RacingRecord record : records) {
                for (int i = 0; i < record.getPosition(); i++) {
                    System.out.print(RACING_DISPLAY);
                }
                System.out.println();
            }
        }
    }

}
