package racinggame;

import java.util.List;

public class ResultView {
    private static final String CAR_POSITION_TEXT = "-";

    public static void displayResult(GameResults gameResults) {
        System.out.println("\n실행 결과");
        List<GameResult> gameResultList = gameResults.getGameResultList();
        StringBuilder stringBuilder = new StringBuilder();
        gameResultList.forEach(gameResult -> {
            stringBuilder.append(getCurrentRoundCarsPositionText(gameResult));
        });
        System.out.println(stringBuilder.toString());
    }

    private static String convertToDisplayableText(int carPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            stringBuilder.append(CAR_POSITION_TEXT);
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private static String getCurrentRoundCarsPositionText(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        gameResult.getGameResult().forEach(carPosition -> {
            stringBuilder.append(convertToDisplayableText(carPosition));
        });
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
