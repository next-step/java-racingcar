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
        }
    }

    private void printRaceRecords(Race race) {
        for (RaceRecord raceRecord : race.raceRecords().list()) {
            System.out.println(raceRecord.car().name() + ":" + createPath(raceRecord.position().value()));
        }
        System.out.println();
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
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < winners.size(); index++) {
            stringBuilder.append(winners.get(index).name());
            addComma(winners, index, stringBuilder);
        }

        return String.format(WINNER_MESSAGE, stringBuilder);
    }

    private void addComma(List<Car> winners, int i, StringBuilder sb) {
        if(notLastIndex(winners, i)) sb.append(",");
    }

    private boolean notLastIndex(List<Car> winners, int i) {
        return winners.size() - 1 > i;
    }
}