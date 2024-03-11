package racinggame.view;

import racinggame.domain.Position;
import racinggame.domain.RaceRecord;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void display(List<RaceRecord> raceRecord) {
        for (RaceRecord record : raceRecord) {
            System.out.println(playRecord(record));
        }
    }

    private static String playRecord(RaceRecord record) {
        StringBuilder result = new StringBuilder();
        for (Position position : record.getCarsPositions()) {
            result.append("-".repeat(position.getPosition())).append("\n");
        }
        return result.toString();
    }
}
