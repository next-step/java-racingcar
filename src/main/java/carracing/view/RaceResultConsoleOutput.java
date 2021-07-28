package carracing.view;

import carracing.domain.CarStatus;
import carracing.domain.RaceResult;
import carracing.domain.RoundRecord;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceResultConsoleOutput {

    private static final String CAR_SYMBOL = "-";
    private static final String WINNER_RESULT_SUFFIX = "가 최종 우승했습니다.";

    public void printRaceRecords(RaceResult raceResult) {
        System.out.println("실행 결과");
        printAllRounds(raceResult.getRoundRecords());
        printAllWinners(raceResult.getWinners());
    }

    private void printAllRounds(List<RoundRecord> roundRecords) {
        System.out.println(roundsToConsoleOutput(roundRecords));
    }

    private void printAllWinners(List<String> winners) {
        System.out.println(winnersToConsoleOutput(winners));
    }

    private String roundsToConsoleOutput(List<RoundRecord> roundRecords) {
        return roundRecords.stream()
                .map(this::drawAllCarPosition)
                .collect(Collectors.joining());
    }

    private String winnersToConsoleOutput(List<String> winners) {
        return winners.stream()
                .collect(Collectors.joining(", ", "", WINNER_RESULT_SUFFIX));
    }

    private String drawAllCarPosition(RoundRecord roundRecord) {
        return roundRecord.getCarStatuses()
                .stream()
                .map(this::drawAccumulatedCarPosition)
                .collect(Collectors.joining("\n", "", "\n\n"));
    }

    private String drawAccumulatedCarPosition(CarStatus carStatus) {
        return IntStream.range(0, carStatus.getPosition())
                .mapToObj(index -> CAR_SYMBOL)
                .collect(Collectors.joining("", carStatus.getName() + " : ", ""));
    }

}
