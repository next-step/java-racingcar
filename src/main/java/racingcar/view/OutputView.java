package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void printTitleMsg(String msg) {
        System.out.println(msg);
    }
    public static void printRaceResult(Map<String, Integer> raceResult) {
        for (Map.Entry entry : raceResult.entrySet()) {
            System.out.println(entry.getKey()+ ":" + "-".repeat((Integer) entry.getValue()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder winnerMsg = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            winnerMsg.append(buildWinnerPrintMsg(winners.get(i).getName(), i == 0));
        }

        winnerMsg.append("가 최종 우승했습니다");

        System.out.println(winnerMsg);

    }

    private static String buildWinnerPrintMsg(String name, boolean isFirstWinner) {
        if (isFirstWinner) {
            return name;
        }
        return "," + name;
    }
}