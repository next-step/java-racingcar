package step3;

import static step3.InputView.inputInt;
import static step3.ResultView.printResultMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static void main(String[] args) {
        startRacing();
    }

    public static void startRacing() {
        Race race = new Race(makeRacingCar(inputInt(ResultView::printCarCount)),
                makeTryCount(inputInt(ResultView::printTryCount)));
        getGameResult(race);
    }

    private static List<Car> makeRacingCar(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    private static int makeTryCount(int tryCount) {
        return tryCount;
    }

    private static void getGameResult(Race race) {
        printResultMessage();
        for (int i = 0; i < race.getTryCount(); i++) {
            race.carMove();
        }
    }
}
