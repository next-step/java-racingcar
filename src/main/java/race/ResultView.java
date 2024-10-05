package race;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PIECE = "-";

    private static void printTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void print(List<CarRaceGameHistory> histories) {
        printTitle();

        Map<Integer, List<CarRaceGameHistory>> historyGroupsByRound =
                histories.stream().collect(Collectors.groupingBy(CarRaceGameHistory::getRound));

        for (Map.Entry<Integer, List<CarRaceGameHistory>> historyGroup : historyGroupsByRound.entrySet()) {
            printByRound(historyGroup.getValue());
        }

        List<CarRaceGameHistory> lastRoundHistories = historyGroupsByRound.get(historyGroupsByRound.size());
        printWinner(lastRoundHistories);
    }

    private static void printByRound(List<CarRaceGameHistory> histories) {
        for (CarRaceGameHistory history : histories) {
            System.out.println(history.getName() + " : " + PIECE.repeat(history.getStep()));
        }
        System.out.println();
    }

    private static void printWinner(List<CarRaceGameHistory> histories) {
        List<CarRaceGameHistory> winningHistories = CarRaceGameHistory.selectWinningHistories(histories);
        String winnerNames = winningHistories.stream().map(CarRaceGameHistory::getName).collect(Collectors.joining(","
        ));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
