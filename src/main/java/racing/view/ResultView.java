package racing.view;

import racing.dto.*;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String POSITION_MARK = "-";
    private static final String CAR_NAME_POSITION_DELIMITER = " : ";
    private static final String WINNERS_MESSAGE = "가 최종우승 했습니다.";

    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void printResult(RacingResult racingResult) {

        printRacingScores(racingResult);
        printWinners(racingResult);
    }

    private void printRacingScores(RacingResult racingResult) {

        racingResult.getEntireRacingScore().forEach(this::printRacingScore);
    }

    private void printRacingScore(RacingScore racingScore) {

        printCarNamePositions(racingScore.getCarNamePositions());
        printNewLine();
    }

    private void printCarNamePositions(List<CarNamePosition> carNamePositions) {

        carNamePositions.forEach(this::printPositionMark);
    }

    private void printPositionMark(CarNamePosition carNamePosition) {

        printString(carNamePosition.getCarName());
        printString(CAR_NAME_POSITION_DELIMITER);
        printPositionMark(carNamePosition.getPosition());
    }

    private void printPositionMark(int position) {

        IntStream.range(0, position)
                .forEach(i -> printStream.print(POSITION_MARK));

        printNewLine();
    }

    private void printWinners(RacingResult racingResult) {

        printString(racingResult.getWinnersName() + WINNERS_MESSAGE);
    }

    private void printString(String s) {

        printStream.print(s);
    }

    private void printNewLine() {

        printStream.println();
    }
}
