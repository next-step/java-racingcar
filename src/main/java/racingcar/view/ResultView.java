package racingcar.view;

import racingcar.model.RaceRecord;
import racingcar.model.RaceWinner;

import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<RaceRecord> records, int raceCount, int totalNumberOfRace) {

        for (RaceRecord record : records) {
            System.out.println(record.getCarName() + " : " + generateDashedString(record.getCarMovingDistance()));
        }

        System.out.println();

        if (raceCount == totalNumberOfRace) {
            printRaceWinner(records);
        }
    }

    private String generateDashedString(int movingDistance) {
        return "-".repeat(movingDistance);
    }

    private void printRaceWinner(List<RaceRecord> records) {
        RaceWinner winner = new RaceWinner(records);
        System.out.println(winner.getNames());
    }
}
