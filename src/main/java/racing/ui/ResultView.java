package racing.ui;

import racing.dto.RacingPosition;
import racing.dto.RacingResult;

import java.io.PrintStream;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String POSITION_MARK = "-";
    private static final String PRINT_NAME_POSITION_DELIMITER = " : ";
    private static final String WINNERS_DELIMITER = ", ";
    private static final String WINNERS_MESSAGE = "가 최종우승 했습니다.";

    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void printRacingResult(RacingResult racingResult) {

        printNewLine();

        IntStream.range(0, racingResult.size())
                .mapToObj(racingResult::getRacingPosition)
                .forEach(this::printRace);

        printWinners(racingResult);
    }

    private void printRace(RacingPosition racingPosition) {

        racingPosition.entrySet().forEach(this::printCarPosition);

        printNewLine();
    }

    // TODO : name, position
    private void printCarPosition(Map.Entry<String, Integer> carNamePositionEntry) {

        printStream.print(carNamePositionEntry.getKey());
        printDelimiter();
        printCarPosition(carNamePositionEntry.getValue());
    }

    private void printDelimiter() {

        printStream.print(PRINT_NAME_POSITION_DELIMITER);
    }

    private void printCarPosition(int position) {

        IntStream.range(0, position)
                .forEach(i -> printStream.print(POSITION_MARK));

        printNewLine();
    }


    private void printWinners(RacingResult racingResult) {

        String winners = getWinners(racingResult);
        printStream.print(winners + WINNERS_MESSAGE);
    }


    private void printNewLine() {

        printStream.println();
    }

    private String getWinners(RacingResult racingResult) {

        int maxPosition = racingResult.getLastRacingPosition().entrySet().stream()
                .map(Map.Entry::getValue)
                .max(Integer::compareTo)
                .orElse(0);

        return racingResult.getLastRacingPosition().entrySet().stream()
                .filter(entry -> maxPosition == entry.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(WINNERS_DELIMITER));
    }
}
