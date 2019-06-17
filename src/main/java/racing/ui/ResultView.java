package racing.ui;

import racing.dto.*;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String POSITION_MARK = "-";
    private static final String CAR_NAME_POSITION_DELIMITER = " : ";
    private static final String NAME_DELIMITTER = ", ";
    private static final String WINNERS_MESSAGE = "가 최종우승 했습니다.";

    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void print(RacingResult racingResult) {

        printStream.println();
        printRacingScores(racingResult);

        printWinners(racingResult);
    }

    private void printRacingScores(RacingResult racingResult) {

        racingResult.getEntireRacingScore().forEach(this::printRacingScore);
    }

    private void printRacingScore(RacingScore racingScore) {

        racingScore.getCarNamePositions().forEach(this::printCarPosition);
        printStream.println();
    }

    private void printCarPosition(CarNamePosition carNamePosition) {

        printStream.print(carNamePosition.getCarName());
        printStream.print(CAR_NAME_POSITION_DELIMITER);
        printCarPosition(carNamePosition.getPosition());
    }

    private void printCarPosition(int position) {

        IntStream.range(0, position)
                .forEach(i -> printStream.print(POSITION_MARK));

        printStream.println();
    }

    private void printWinners(RacingResult racingResult) {

        String winnersName = getWinnersName(racingResult);
        printStream.print(winnersName + WINNERS_MESSAGE);
    }

    private String getWinnersName(RacingResult racingResult) {

        List<CarNamePosition> lastCarNamePositions = racingResult.getLastRacingScore().getCarNamePositions();
        int winnersPosition = lastCarNamePositions.stream()
                .map(CarNamePosition::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException("우승자 계산도중 에러가 발생했습니다."));

        return lastCarNamePositions.stream()
                .filter(carNamePosition -> carNamePosition.getPosition() == winnersPosition)
                .map(CarNamePosition::getCarName)
                .collect(Collectors.joining(NAME_DELIMITTER));

    }
}
