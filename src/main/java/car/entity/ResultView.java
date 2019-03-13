package car.entity;

public class ResultView {
    public static void printGame(GameResult gameResult) {
        gameResult.getRoundResult().forEach(aCar -> {
            aCar.printStatus();
        });
        System.out.println();
    }

    public static void printGameWinner(GameResult gameResult) {
        StringBuffer winnerString = new StringBuffer();

        gameResult.getGameWinner().forEach(car -> {
            winnerString.append(car.name + " ");
        });

        winnerString.append("가 최종 우승했습니다.");

        System.out.println(winnerString);
    }
}
