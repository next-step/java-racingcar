package step4.domain;

import step4.ui.InputView;
import step4.ui.ResultView;

import java.util.List;

import static step4.ui.ResultView.*;

public class RunRace {
    public static void main(String[] args) {
        raceStartBroadcast();
    }

    private static void raceStartBroadcast() {
        List<Car> cars = Car.ofCars(InputView.getRacerNames());
        int totalLaps = InputView.getTotalLaps();
        raceStartAnnounce(cars);
        RunRace.raceStart(cars, totalLaps);
    }

    private static void raceStart(List<Car> cars, int inputLaps) {
        int drivingProgress = 0;
        for (int i = 0; i < inputLaps; i++) {
            drivingProgress = getProgress(cars, drivingProgress);
            drawLine(NEW_LINE);
        }
        ResultView.showFinalChampion(cars, drivingProgress);
    }

    private static int getProgress(List<Car> cars, int champion) {
        for (Car a : cars) {
            a.goAhead(Accelerator.ofAccelerator());
            a.myState();
            champion = (champion > a.getLocation()) ? champion : a.getLocation();
        }
        return champion;
    }
}
