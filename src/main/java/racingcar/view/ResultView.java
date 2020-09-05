package racingcar.view;

import racingcar.domain.RaceResults;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;
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
                (key, value) -> System.out.printf("%s : %s \n", key, repeat(PRINT_GO, value))
        );
        System.out.println();
    }

    public static void printWinners(Cars cars) {outputChannel.printLine(cars.getWinnersNames() + SAY_WINNER_CARS_NAMES); }
}
