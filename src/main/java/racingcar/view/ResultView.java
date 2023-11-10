package racingcar.view;

import racingcar.domain.CarName;
import racingcar.race.Race;
import racingcar.domain.RaceRecord;

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
            System.out.println(raceRecord.carName().value() + ":" + createPath(raceRecord.position().value()));
        }
        System.out.println();
    }

    private String createPath(int count) {
        return CAR_PATH.repeat(count);
    }

    public void printWinner(List<Race> races) {
        Race lastRace = races.get(races.size() - 1);
        List<CarName> winners = lastRace.raceRecords().winners();
        System.out.println(winnerMessage(winners));
    }

    private String winnerMessage(List<CarName> winners) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < winners.size(); index++) {
            stringBuilder.append(winners.get(index).value());
            addComma(winners, index, stringBuilder);
        }

        return String.format(WINNER_MESSAGE, stringBuilder);
    }

    private void addComma(List<CarName> winners, int i, StringBuilder sb) {
        if(notLastIndex(winners, i)) sb.append(",");
    }

    private boolean notLastIndex(List<CarName> winners, int i) {
        return winners.size() - 1 > i;
    }
}