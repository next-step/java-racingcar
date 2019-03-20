package car.view;

import car.domain.GameResult;

public class ResultView {
    public static void printGame(GameResult gameResult) {
        StringBuffer gameString = new StringBuffer();

        gameResult.getRoundResult().forEach(aCar -> {
            gameString.append(aCar.toString());
        });

        System.out.println(gameString.toString());
    }

    public static void printGameWinner(GameResult gameResult) {
        StringBuffer winnerString = new StringBuffer();

        for(String name : gameResult.getWinnerNames()) {
            winnerString.append(name);
            winnerString.append(" ");
        }

        winnerString.append("가 최종 우승했습니다.");

        System.out.println(winnerString);
    }
}
