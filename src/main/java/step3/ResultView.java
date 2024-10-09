package step3;

import java.util.Map;

public class ResultView {

    public static void result(GameResults gameResults) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameResults.getSize(); i++) {
            printRoundResult(gameResults.getRoundResult(i));
            System.out.println();
        }
        System.out.println(gameResults.getWinners() + "가 최종 우승했습니다.");
    }

    private static void printRoundResult(RoundResult roundResult) {
        for (Map.Entry<String, Integer> entry : roundResult.getEntrySet()) {
            System.out.println(appendDistanceBar(entry));
        }
    }

    private static StringBuilder appendDistanceBar(Map.Entry<String, Integer> entry) {
        StringBuilder distance = new StringBuilder();
        distance.append(entry.getKey()).append(" : ").append("-".repeat(Math.max(0, entry.getValue())));
        return distance;
    }
}
