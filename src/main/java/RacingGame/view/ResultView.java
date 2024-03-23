package RacingGame.view;

import RacingGame.common.ErrorMessageConstants;
import RacingGame.model.CarsHistory;

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
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : play.entrySet()) {
            String carName = entry.getKey();
            int carPosition = entry.getValue();
            sb.append(String.format("%s : %s", carName, makeHypens(carPosition)));
            sb.append(System.lineSeparator());
        }

        sb.append(System.lineSeparator());
        System.out.println(sb);
    }

    private static String makeHypens(int count) {
        return CAR_POSITION_UNIT.repeat(count);
    }

    public static void showWinners(List<String> winnerNames) {
        System.out.println(new StringBuilder()
                .append(String.join(",", winnerNames))
                .append("가 최종 우승했습니다"));
    }

    public static void showProgress(CarsHistory histories) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < histories.StageCount(); i++) {
            showStage(histories, sb, i);
        }
        System.out.println(sb);
    }

    private static void showStage(CarsHistory histories, StringBuilder sb, int stage) {
        for (String carName : histories.getCarsHistory().keySet()) {
            int carPosition = histories.getCarsHistory().get(carName).get(stage).getPosition();
            sb.append(String.format("%s : %s", carName, makeHypens(carPosition)));
            sb.append(System.lineSeparator());
        }
        sb.append(System.lineSeparator());
    }
}
