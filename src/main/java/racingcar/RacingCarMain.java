package racingcar;

import static racingcar.domain.RacingGamesFactory.createRacingGames;
import static racingcar.view.InputView.*;
import static racingcar.view.ResultView.*;


public class RacingCarMain {
    public static void main(String[] args) {
        createRacingGames(getCarNames(), getRacingCounts());
        printStartResult();
        printEmptyLine();
        for (int i = 0 ; i < racingGames.getRacingCounts(); i++) {
            printCars(racingGame.recordRacing());
            resultView.printEmptyLine();
       // }
        resultView.printWinners(racingGame.recordWinnerCars());
    }
}
