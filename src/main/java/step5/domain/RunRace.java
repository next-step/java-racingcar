package step5.domain;

import step5.ui.InputView;
import step5.ui.ResultView;

import java.util.List;

import static step5.domain.CheckerFlag.showFinalChampion;
import static step5.domain.RelayCamera.showLocation;
import static step5.ui.ResultView.NEW_LINE;
import static step5.ui.ResultView.drawLine;
import static step5.ui.ResultView.raceStartAnnounce;

public class RunRace {
    private static void raceStartBroadcast() {
        List<Car> cars = Car.ofCars(InputView.getRacerNames());
        int totalLaps = InputView.getTotalLaps();
        raceStartAnnounce(cars);
        RunRace.raceStart(cars, totalLaps);
        //ResultView.raceWinnerAnnounce();
    }

    private static void raceStart(List<Car> cars, int inputLaps) {
        int currentLocation = 0;
        for (int i = 0; i < inputLaps; i++) {
            currentLocation = getProgress(cars, currentLocation);
            drawLine(NEW_LINE);
        }
        showFinalChampion(cars, currentLocation);
    }

    private static int getProgress(List<Car> cars, int currentLocation) {
        for (Car car : cars) {
            car.goAhead(Accelerator.ofAccelerator());
            ResultView.racingRelay(car.getDriverName(), car.getLocation());
            currentLocation = showLocation(currentLocation, car.getLocation());
        }
        return currentLocation;
    }
}
