package racing;

import java.util.*;

public class ResultView {

    public ResultView() {
    }

    public void status(String name, int distance) {
        System.out.println(name + ": " + position(distance));
    }

    private String position(int distance) {
        return "-".repeat(Math.max(0, distance));
    }

    public static void raceResult(List<Car> cars) {
        String winners = new Racing().winner(cars).toString();
        System.out.println(winners.substring(1, winners.length() - 1) + "가 최종 우승하였습니다.");
    }
}
