package racingcar.view;

import racingcar.domain.RaceResults;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Cars;

import java.util.List;

import static racingcar.utils.Constants.*;
import static racingcar.utils.StringUtils.repeat;

public class ResultView{

    private static OutputChannel outputChannel = OutputChannel.createSystemOut();

    public static void printStartResult() {
        outputChannel.printLine("\n"+SAY_VIEW_RESULT);
    }

    public static void printRaceResult(RacingGame racingGame) {
        List<RaceResults> raceResults = racingGame.getRaceResults();
        raceResults.forEach(ResultView::printRaceRecord);
        printWinners(racingGame.getCars( ));

    }

    private static void printRaceRecord(RaceResults raceResults) {
        raceResults.getRaceHist().forEach(
                (key, value) -> outputChannel.printLine(printCars(key, value))
        );
        printEmptyLine();
    }

    private static String printCars(String key, Integer value) {
        return String.format("%s : %s", key, repeat(PRINT_GO, value));
    }

    private static void printEmptyLine() {outputChannel.printLine("");}
    private static void printWinners(Cars cars) {outputChannel.printLine(cars.getWinnersNames() + SAY_WINNER_CARS_NAMES); }


}
