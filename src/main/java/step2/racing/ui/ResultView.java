package step2.racing.ui;

import step2.racing.dto.CarPosition;
import step2.racing.dto.RacingResult;

import java.io.PrintStream;
import java.util.stream.IntStream;

import static step2.racing.service.RacingService.START_UNIQUE_CAR_NUMBER;

public class ResultView {

    private static final String POSITION_MARK = "-";

    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void printTotalRaces(RacingResult racingResult) {

        printNewLine();

        IntStream.range(0, racingResult.length())
                .mapToObj(racingResult::getCarPosition)
                .forEach(this::printRace);
    }

    private void printRace(CarPosition carPosition) {

        IntStream.rangeClosed(START_UNIQUE_CAR_NUMBER, carPosition.sizeOfCars())
                .map(carPosition::getPosition)
                .forEach(this::printCarPosition);

        printNewLine();
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
