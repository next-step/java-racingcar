package racing.ui;

import racing.CarRacing;
import racing.model.RaceRecord;
import racing.util.StringUtil;

import java.util.List;

public class ResultView {

    public static final String RAIL_STRING = "_";

    public void printResult(CarRacing carRacing) {
        List<RaceRecord> raceRecords = carRacing.getRaceRecords();
        raceRecords.forEach(this::printRaceRecord);
    }

    private void printRaceRecord(RaceRecord raceRecord) {
        System.out.println("RACE :: " + raceRecord.getRaceId());
        raceRecord.getTrackRecord().stream()
                .map(r -> StringUtil.makeRepeatString(r, RAIL_STRING))
                .forEach(System.out::println);
    }

}
