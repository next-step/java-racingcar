package racing.ui;

import racing.dto.CarPosition;
import racing.dto.RacingResult;

import java.io.PrintStream;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {

    private static final String POSITION_MARK = "-";

    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void printRacingResult(RacingResult racingResult) {

        printNewLine();

        IntStream.range(0, racingResult.length())
                .mapToObj(racingResult::getCarPosition)
                .forEach(this::printRace);
    }

    private void printRace(CarPosition carPosition) {

        carPosition.entrySet().forEach(this::printCarPosition);

        printNewLine();
    }

    private void printCarPosition(Map.Entry<String, Integer> carNamePositionEntry) {

        printStream.print(carNamePositionEntry.getKey());
        printDelimiter();
        printCarPosition(carNamePositionEntry.getValue());
    }

    private void printDelimiter() {

        printStream.print(" : ");
    }

    private void printCarPosition(int position) {

        IntStream.range(0, position)
                .forEach(i -> printStream.print(POSITION_MARK));

        printNewLine();
    }

    private void printNewLine() {

        printStream.println();
    }
}
