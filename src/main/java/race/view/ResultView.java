package race.view;

import race.domain.CarRaceGameHistory;
import race.domain.CarRaceGameRoundHistories;

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

        CarRaceGameRoundHistories roundHistories = CarRaceGameRoundHistories.create(histories.stream()
                .collect(Collectors.groupingBy(CarRaceGameHistory::getRound)));

        for (Map.Entry<Integer, List<CarRaceGameHistory>> historyGroup : roundHistories.get()
                .entrySet()) {
            printByRound(historyGroup.getValue());
        }

        printWinner(roundHistories.selectWinners());
    }

    private static void printByRound(List<CarRaceGameHistory> histories) {
        for (CarRaceGameHistory history : histories) {
            System.out.println(history.getName() + " : " + PIECE.repeat(history.getStep()));
        }
        System.out.println();
    }

    private static void printWinner(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
}
