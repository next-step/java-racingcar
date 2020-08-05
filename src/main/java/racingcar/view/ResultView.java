package racingcar.view;

import racingcar.model.RacingRecord;

public class ResultView {

    public static void displayResult(RacingRecord racingRecord) {
        StringBuilder builder = new StringBuilder();
        int round = 1;
        System.out.println("실행 결과");
        for (String record : racingRecord.getAllRecord()) {
            builder.append("[ROUND ").append(round++).append("]").append("\n");
            builder.append(record).append("\n");
        }
        System.out.println(builder.toString());
    }
}
