package racingcar.domain;

import racingcar.view.ResultView;

import static racingcar.view.InputView.inputCarList;
import static racingcar.view.InputView.inputInt;
import static racingcar.view.ResultView.*;

public class RacingCar {
    public static void startRacing() {
        Race race = makeRace();
        getGameResult(race);
        printWinnerCarName(race.getWinnerCarNames());
    }

    public static Race makeRace() {
        while (true) {
            try {
                return new Race(inputCarList(ResultView::printRaceCarName), inputInt(ResultView::printTryCount));
            } catch (Exception ex) {
                printErrorMessage(ex);
            }
        }
    }

    private static void getGameResult(Race race) {
        printResultMessage();
        race.startTry();
    }
}
