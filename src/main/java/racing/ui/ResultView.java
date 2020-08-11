package racing.ui;

import racing.car.CarRacing;
import racing.car.model.RaceRecord;
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
        raceRecord.getTrackRecords().forEach(
            (key, value) -> System.out.printf("%s : %s \n", key, StringUtil.makeRepeatString(value, RAIL_STRING))
        );
        System.out.println();
    }

}
