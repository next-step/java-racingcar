package racingcar.view;

import racingcar.domain.RaceResults;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Cars;

import java.util.List;

import static racingcar.utils.Constants.*;
import static racingcar.utils.StringUtils.repeat;

public class ResultView{

    private static OutputChannel outputChannel = new SystemOut();

    public static void printRaceResult(RacingGame racingGame) {
        printStartResult();
        List<RaceResults> raceResults = racingGame.getRaceResults();
        raceResults.forEach(ResultView::printRaceRecord);
        printWinners(racingGame);

    }

    private static void printStartResult() {
        outputChannel.printLine("\n"+SAY_VIEW_RESULT);
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
    private static void printWinners(RacingGame racingGame) {outputChannel.printLine(racingGame.findWinners() + SAY_WINNER_CARS_NAMES); }


}
