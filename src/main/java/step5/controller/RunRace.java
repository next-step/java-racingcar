package step5.controller;

import step5.domain.Accelerator;
import step5.domain.Car;
import step5.domain.FrontLine;
import step5.ui.InputView;
import step5.ui.ResultView;

import java.util.List;

import static step5.domain.CheckerFlag.showFinalChampion;
import static step5.domain.RelayCamera.moveLocation;
import static step5.ui.ResultView.NEW_LINE;
import static step5.ui.ResultView.drawLine;

public class RunRace {

    public static void main(String[] args) {
        String racerNames = FrontLine.validNames(InputView.getRacerNames());
        int totalLaps = InputView.getTotalLaps();
        List<Car> cars = Car.ofCars(racerNames);
        String winner = doRace(cars, totalLaps);
        ResultView.raceWinnerAnnounce(winner);
    }

    private static String doRace(List<Car> cars, int inputLaps) {
        int currentLocation = 0;
        for (int i = 0; i < inputLaps; i++) {
            currentLocation = getProgress(cars, currentLocation);
            drawLine(NEW_LINE);
        }
        return showFinalChampion(cars, currentLocation);
    }

    public static int getProgress(List<Car> cars, int currentLocation) {
        for (Car car : cars) {
            car.goAhead(Accelerator.ofAccelerator());
            ResultView.racingRelay(car.getDriverName(), car.getLocation());
            currentLocation = moveLocation(currentLocation, car.getLocation());
        }
        return currentLocation;
    }
}
