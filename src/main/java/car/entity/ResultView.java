package car.entity;

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

        gameResult.getWinnerNames().forEach(car -> {
            winnerString.append(car.getName() + " ");
        });

        winnerString.append("가 최종 우승했습니다.");

        System.out.println(winnerString);
    }
}
