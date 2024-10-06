package racingcar;

import static racingcar.InputView.inputCarList;
import static racingcar.InputView.inputInt;
import static racingcar.ResultView.printResultMessage;
import static racingcar.ResultView.printWinnerCarName;

import java.util.ArrayList;
import java.util.List;

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
