package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceRecord {
    private static final String NEW_LINE = "\n";
    private final List<Cars> raceResult;

    public RaceRecord() {
        this.raceResult = new ArrayList<>();
    }

    public void addRecord(Cars cars) {
        raceResult.add(cars);
    }

    public int getSize() {
        return raceResult.size();
    }

    public String getRecord() {
        String record = "";
        for (Cars cars : raceResult) {
            record += cars.toString() + NEW_LINE;
        }
        return record;
    }

    public String getRaceWinners() {
        return findRaceWinners(raceResult.get(raceResult.size() - 1));
    }

    private String findRaceWinners(Cars cars) {
        Car winner = cars.getCurrentWinner();
        RaceWinners winners = cars.findRaceWinners(winner);
        return winners.toString();
    }

}
