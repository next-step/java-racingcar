package racingcar;

import static racingcar.InputView.inputCarList;
import static racingcar.InputView.inputInt;
import static racingcar.ResultView.printResultMessage;
import static racingcar.ResultView.printWinnerCarName;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static void main(String[] args) {
        startRacing();
    }

    public static void startRacing() {
        Race race = new Race((inputCarList(ResultView::printRaceCarName)),
                makeTryCount(inputInt(ResultView::printTryCount)));
        getGameResult(race);
        printWinnerCarName(race.getWinnerCarList());
    }


    private static int makeTryCount(int tryCount) {
        return tryCount;
    }

    private static void getGameResult(Race race) {
        printResultMessage();
        for (int i = 0; i < race.getTryCount(); i++) {
            race.carMove();
        }
        race.setMaxDistance();
    }
}
