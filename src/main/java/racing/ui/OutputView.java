package racing.ui;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racing.domain.Race;
import racing.domain.RaceResult;
import racing.domain.Record;
import racing.domain.ScoreBoard;

public class OutputView {

    private static final String ROAD = "-";
    private static final String NAME_SEPARATOR = ", ";

    public static void showResult(Race race) {
        ScoreBoard scoreBoard = race.result();
        System.out.println("실행 결과");
        for (RaceResult raceResult : scoreBoard.raceResults()) {
            showCarLocationsWithName(raceResult.records());
            System.out.println();
        }
        showWinner(scoreBoard.winners());
    }

    private static void showWinner(List<Record> records){
        String winners = joinWinnersName(records);
        System.out.printf("%s가 최종 우승했습니다.", winners);
    }

    private static String joinWinnersName(List<Record> records) {
        return records.stream()
                .map(Record::getName)
                .collect(Collectors.joining(NAME_SEPARATOR));
    }

    private static void showCarLocationsWithName(List<Record> records) {
        for (Record record : records) {
            String road = ROAD.repeat(Math.max(0, record.getLocation()));
            System.out.printf("%s : %s%n", record.getName(), road);
        }
    }
}
