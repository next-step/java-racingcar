package car.view;

import car.domain.GameResult;

public class WebResultView {
    public static String printGameWinner(GameResult gameResult) {
        StringBuffer winnerString = new StringBuffer();

        for(String name : gameResult.getWinnerNames()) {
            winnerString.append(name);
            winnerString.append(" ");
        }

        return winnerString.toString();
    }
}
