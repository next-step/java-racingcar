package step3.util;

import step3.game.GameHistory;

import java.util.List;

public class OutputView {

    public static void printResult(List<List<GameHistory>> result, List<String> winners) {
        System.out.println("실행결과");
        printHistories(result);
        printWinners(winners);
    }

    private static void printHistories(List<List<GameHistory>> result) {
        for (List<GameHistory> history : result) {
            for (int i = 0; i < history.size(); i++) {
                System.out.println(history.get(i).toString());
            }
            System.out.println();
        }
    }

    private static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
