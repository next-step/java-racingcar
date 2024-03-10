package racinggame.view;

import racinggame.domain.RaceRecord;

import java.util.List;

public class ResultView {

    private ResultView() {}

    public static void display(List<RaceRecord> raceRecord) {
        for (RaceRecord record : raceRecord) {
            System.out.println(record.display());
        }
    }
}
