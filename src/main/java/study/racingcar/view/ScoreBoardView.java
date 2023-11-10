package study.racingcar.view;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import study.racingcar.Car;
import study.racingcar.MoveStatus;

public class ScoreBoardView {

    private static final String MOVE_SCORE = "-";
    private static final String STOP_SCORE = "";


    public static String scoreToString(MoveStatus moveStatus) {
        if (moveStatus.equals(MoveStatus.MOVE)) {
            return MOVE_SCORE;
        }
        return STOP_SCORE;
    }

    public static void printResult(List<Map<Car, String>> listMap) {
        listMap.forEach(map -> {
            map.forEach((car, s) -> {
                System.out.print(car.name() + " : ");
                System.out.println(s);
            });
            System.out.println("\n");
        });
    }

    public static void printWinner(LinkedList<Map<Car, String>> result) {
        Map<Car, String> map = result.getLast();

        String maxValue = map.entrySet().stream()
            .max((e1, e2) -> e1.getValue().length() > e2.getValue().length() ? 1 : -1).get()
            .getValue();

        List<String> winners = map.entrySet().stream()
            .filter(carStringEntry -> carStringEntry.getValue().equals(maxValue))
            .map(Entry::getKey)
            .map(Car::name)
            .collect(Collectors.toList());

        String joinedWinners = String.join(", ", winners);
        System.out.println(joinedWinners + "가 최종 우승했습니다." );

    }
}
