package racing.application;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {

    public static String getWinners(List<Car> cars) {
        List<String> winners = judgeWinners(sortByPosition(cars));
        return listToString(winners);
    }

    private static String listToString(List<String> winners) {
        return winners.stream().collect(Collectors.joining(","));
    }

    private static List<Car> sortByPosition(List<Car> cars) {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> judgeWinners(List<Car> sorted) {
        return sorted.stream()
                .filter(v -> getWinnerPosition(sorted) == v.getPosition())
                .map(v -> v.getName())
                .collect(Collectors.toList());
    }

    private static int getWinnerPosition(List<Car> sorted) {
        return sorted.get(0).getPosition();
    }



}
