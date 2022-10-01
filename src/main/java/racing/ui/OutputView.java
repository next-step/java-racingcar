package racing.ui;

import java.util.List;
import racing.domain.Race;
import racing.domain.RaceResult;
import racing.domain.ScoreBoard;

public class OutputView {

    private static final String ROAD = "-";

    public static void showResult(Race race) {
        ScoreBoard scoreBoard = race.result();
        System.out.println("실행 결과");
        for (RaceResult raceResult : scoreBoard.raceResults()) {
            showCarLocations(raceResult.carLocations());
            System.out.println();
        }
    }

    private static void showCarLocations(List<Integer> carsLocations) {
        for (Integer carLocation : carsLocations) {
            String road = ROAD.repeat(Math.max(0, carLocation));
            System.out.println(road);
        }
    }
}
