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
        Long time = rule.getTime();
        System.out.println("실행 결과");
        for (Long now = 0L; now < time; now++) {
            printHistory(gameHistory.getHistory(now));
        }
    }

    private void printHistory(List<Long> history) {
        history.stream().forEach(item -> printPosition(item));
        System.out.println();
    }

    private void printPosition(Long item) {
        for (Long i = 0L; i < item; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
