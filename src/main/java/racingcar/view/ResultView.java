package racingcar.view;

import racingcar.race.Car;
import racingcar.race.Race;
import racingcar.race.RaceRecord;

import java.util.List;

public class ResultView {

    private static final String CAR_PATH = "-";
    public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

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
        for (RaceRecord raceRecord : race.raceRecords().list()) {
            System.out.println(raceRecord.car().name() + ":" + createPath(raceRecord.distance()));
        }
    }

    private String createPath(int count) {
        return CAR_PATH.repeat(count);
    }

    public void printWinner(List<Race> races) {
        Race lastRace = races.get(races.size() - 1);
        List<Car> winners = lastRace.raceRecords().winners();
        System.out.println(winnerMessage(winners));
    }

    private String winnerMessage(List<Car> winners) {
        StringBuilder sb = new StringBuilder();

        for (Car winner : winners) {
            sb.append(winner.name() + ",");
        }

        return String.format(WINNER_MESSAGE, removeLastComma(sb));
    }

    private String removeLastComma(StringBuilder sb) {
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
