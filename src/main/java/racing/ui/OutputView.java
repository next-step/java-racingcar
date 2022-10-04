package racing.ui;

import java.util.List;
import racing.domain.Race;
import racing.domain.RaceResult;
import racing.domain.Record;
import racing.domain.ScoreBoard;

public class OutputView {

    private static final String ROAD = "-";

    public static void showResult(Race race) {
        ScoreBoard scoreBoard = race.result();
        System.out.println("실행 결과");
        for (RaceResult raceResult : scoreBoard.raceResults()) {
            showCarLocationsWithName(raceResult.records());
            System.out.println();
        }
    }

    private static void showCarLocationsWithName(List<Record> records) {
        for (Record record : records) {
            String road = ROAD.repeat(Math.max(0, record.getLocation()));
            System.out.printf("%s : %s%n", record.getName(), road);
        }
    }
}
