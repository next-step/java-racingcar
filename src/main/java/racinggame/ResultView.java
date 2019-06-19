package racinggame;

import com.google.common.base.Strings;

import java.util.List;

public class ResultView {
    private static final String CAR_POSITION_TEXT = "-";

    public static void displayResult(GameResults gameResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n실행 결과\n");

        List<GameResult> gameResultList = gameResults.getGameResults();
        gameResultList.forEach(gameResult -> {
            stringBuilder.append(getCurrentRoundCarsPositionText(gameResult));
        });

        int lastIndex = gameResults.getGameResults().size() - 1;
        GameResult lastRoundResult = gameResults.getGameResults().get(lastIndex);

        stringBuilder.append(lastRoundResult.getWinner());
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }

    private static String convertToDisplayableText(String carName, int carPosition) {
        return carName + " : " + Strings.repeat(CAR_POSITION_TEXT, carPosition);
    }

    private static String getCurrentRoundCarsPositionText(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        gameResult.getGameResult().forEach((carName, carPosition) -> {
            stringBuilder.append(convertToDisplayableText(carName, carPosition));
            stringBuilder.append("\n");
        });
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
