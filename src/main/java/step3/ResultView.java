package step3;

import java.util.List;

public class ResultView {

    private final GameHistory gameHistory;
    private final GameInformation gameInformation;

    private ResultView(GameHistory gameHistory, GameInformation gameInformation) {
        this.gameHistory = gameHistory;
        this.gameInformation = gameInformation;
    }

    public static ResultView from(GameHistory gameHistory, GameInformation gameInformation) {
        return new ResultView(gameHistory, gameInformation);
    }

    public void view() {
        Integer time = gameInformation.getTime();
        System.out.println("실행 결과");
        for (int now = 0; now < time; now++) {
            printHistory(gameHistory.getHistory(now));
        }
    }

    private void printHistory(List<Position> history) {
        history.stream().forEach(item -> printPosition(item));
        System.out.println();
    }

    private void printPosition(Position item) {
        System.out.println(item.positionToString());
    }
}
