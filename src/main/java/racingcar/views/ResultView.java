package racingcar.views;

import racingcar.domains.RacingResult;

import java.util.List;

public class ResultView {

    public static final String STR_RESULT_TITLE = "실행 결과";
    public static final String STR_DASH = "-";

    private ResultView() {}

    public static void showRaceResult(List<RacingResult> racingResults) {
        System.out.println(STR_RESULT_TITLE);

        for (int i = 0; i < racingResults.size(); i++) {
            List<Integer> records = racingResults.get(i).getRecords();

            drawRacingRecordsPerRound(records);
        }
    }

    private static void drawRacingRecordsPerRound(List<Integer> records) {
        for (int j = 0; j < records.size(); j++) {
            int carPosition = records.get(j);
            drawCarCurrentPosition(carPosition);
        }

        System.out.println();
    }

    private static void drawCarCurrentPosition(int carPosition) {
        StringBuilder sb = new StringBuilder();
        sb.append(STR_DASH);

        for (int p = 0; p < carPosition; p++) {
            sb.append(STR_DASH);
        }

        System.out.println(sb.toString());
    }
}
