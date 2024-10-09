package racingcar.controller;

import static racingcar.view.InputView.inputCarList;
import static racingcar.view.InputView.inputInt;
import static racingcar.view.ResultView.printErrorMessage;
import static racingcar.view.ResultView.printGoDistance;
import static racingcar.view.ResultView.printResultMessage;
import static racingcar.view.ResultView.printWinnerCarName;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.ResultView;

public class RacingCarController {
    public static void main(String[] args) {
        String[] carNames= inputCarList(ResultView::printRaceCarName);
        int tryCount  = inputInt(ResultView::printTryCount);
        startRacing(carNames, tryCount);
    }

    public static void startRacing(String[] carNames, int tryCount) {
        Race race = makeRace(carNames, tryCount);
        getGameResult(race, tryCount);
        printWinnerCarName(race.getWinnerCarNames());
    }

    public static Race makeRace(String[] carNames, int tryCount) {
        while (true) {
            try {
                return new Race(carNames, tryCount);
            } catch (Exception ex) {
                printErrorMessage(ex);
            }
        }
    }

    private static void getGameResult(Race race, int tryCount) {
        printResultMessage();
        for(int i=0;i<tryCount;i++){
            race.carMove();
        }
        printCarList(race.getCarList());
        System.out.println();
    }


    private static void printCarList(List<Car> carList) {
        for (Car car : carList) {
            printCarRaceResult(car);
            System.out.println();
        }
    }
    public static void printCarRaceResult(Car car) {
        printGoDistance(car);
    }
}
