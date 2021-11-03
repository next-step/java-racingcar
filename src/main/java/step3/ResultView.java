package step3;

import java.util.List;

public class ResultView {

    private final GameHistory gameHistory;
    private final Rule rule;

    private ResultView(GameHistory gameHistory, Rule rule) {
        this.gameHistory = gameHistory;
        this.rule = rule;
    }

    public static ResultView from(GameHistory gameHistory, Rule rule) {
        return new ResultView(gameHistory, rule);
    }

    public void view() {
        Integer time = rule.getTime();
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
