package racingcar;

import java.util.List;

public class ResultView {

    private static final String LINE = "-".repeat(5);

    public static void roundStart(int roundNumber) {
        System.out.println(LINE + roundNumber + " 라운드 시작!" + LINE);
    }

    public static void drawCarPositions(List<RacingResult> results) {
        for (RacingResult result : results) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(result.getName())
                    .append(" : ")
                    .append("-".repeat(result.getPosition()));
            System.out.println(stringBuilder.toString());
        }
    }
}
