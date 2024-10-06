package racingcar.domain;

import racingcar.view.ResultView;

import static racingcar.view.InputView.inputCarList;
import static racingcar.view.InputView.inputInt;
import static racingcar.view.ResultView.printResultMessage;
import static racingcar.view.ResultView.printWinnerCarName;

public class RacingCar {



    public static void startRacing() {
        Race race = new Race((inputCarList(ResultView::printRaceCarName)),
                makeTryCount(inputInt(ResultView::printTryCount)));
        getGameResult(race);
        printWinnerCarName(race.getWinnerCarNames());
    }


    private static int makeTryCount(int tryCount) {
        return tryCount;
    }

    private static void getGameResult(Race race) {
        printResultMessage();
        race.startTry();
    }
}
