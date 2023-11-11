package study.racingcar.view;

import java.util.List;
import java.util.Map;
import study.racingcar.Car;
import study.racingcar.History;
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

    public static void printResult(History history) {
        List<Map<Car, String>> listMap = history.history();
        listMap.forEach(map -> {
            map.forEach((car, s) -> {
                System.out.print(car.name() + " : ");
                System.out.println(s);
            });
            System.out.println("\n");
        });
    }

    public static void printWinner(List<String> winners) {
        String joinedWinners = String.join(", ", winners);
        System.out.println(joinedWinners + "가 최종 우승했습니다." );
    }
}
