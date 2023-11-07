package racingcar.view;

import racingcar.race.Race;
import racingcar.race.RaceRecord;

import java.util.List;

public class ResultView {

    private static final String CAR_PATH = "-";

    public void print(List<Race> races) {
        printRaces(races);
    }

    private void printRaces(List<Race> races) {
        for (Race race : races) {
            printRaceRecords(race);
            System.out.println();
        }
    }

    private void printRaceRecords(Race race) {
        for (RaceRecord raceRecord : race.raceRecords()) {
            System.out.println(createPath(raceRecord.distance()));
        }
    }

    private String createPath(int count) {
        return CAR_PATH.repeat(count);
    }
}
