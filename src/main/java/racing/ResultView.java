package racing;

import java.util.*;

public class ResultView {

    private ResultView() {
    }

    public static void raceResult(List<Car> cars) {
        String winners = new Racing().winner(cars).toString();
        System.out.println(winners.substring(1, winners.length() - 1) + "가 최종 우승하였습니다.");
    }
}
