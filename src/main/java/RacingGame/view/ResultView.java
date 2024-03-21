package RacingGame.view;

import RacingGame.common.ErrorMessageConstants;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String INIT_RESULT_PHRASE = "실행 결과";
    private static final String CAR_POSITION_UNIT = "-";

    private ResultView() {
        throw new AssertionError(ErrorMessageConstants.CONSTRUCTOR_ERROR_MESSAGE.getMessage());
    }

    public static void viewResultPhrase() {
        System.out.println(INIT_RESULT_PHRASE);
    }

    public static void stageStatus(Map<String, Integer> play) {
        for (Map.Entry<String, Integer> entry : play.entrySet()) {
            String carName = entry.getKey();
            int carPosition = entry.getValue();
            System.out.println(String.format("%s : %s", carName, makeHypens(carPosition)));
        }

        System.out.println();
    }

    private static String makeHypens(int count) {
        return CAR_POSITION_UNIT.repeat(count);
    }

    public static void showWinners(List<String> winnerNames) {
        System.out.println(new StringBuilder()
                .append(String.join(",", winnerNames))
                .append("가 최종 우승했습니다"));
    }
}
