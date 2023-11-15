package study.racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import study.racingcar.domain.car.Car;
import study.racingcar.domain.history.History;

public class ScoreBoardView {

    private static final String MOVE_SCORE = "-";

    public static void printResult(History history) {
        List<Map<Car, Integer>> listMap = history.history();
        listMap.forEach(map -> {
            map.forEach((car, i) -> {
                System.out.print(car.name() + " : ");
                System.out.println(socreToString(i));
            });
            System.out.println("\n");
        });
    }

    public static String socreToString(Integer i) {
        return IntStream.range(0, i).mapToObj(j -> MOVE_SCORE).collect(Collectors.joining());
    }


    public static void printWinner(List<String> winners) {
        String joinedWinners = String.join(", ", winners);
        System.out.println(joinedWinners + "가 최종 우승했습니다.");
    }
}
