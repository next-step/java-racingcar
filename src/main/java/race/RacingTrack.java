package race;

import java.util.ArrayList;
import java.util.List;

public class RacingTrack {
    private final List<RacingCar> cars;
    private final int numOfAttempts;

    public RacingTrack(int numOfCars, int numOfAttempts) {
        this.numOfAttempts = numOfAttempts;
        this.cars = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            cars.add(RacingCarFactory.create(i, ResultView.createPositionPrinter()));
        }
    }

    public void startRace() {
        ResultView.printRaceStartMessage();
        for (int i = 0; i < numOfAttempts; i++) {
            moveAndShowCars();
            ResultView.printRaceStatus(cars);
        }
    }

    private void moveAndShowCars() {
        for (RacingCar car : cars) {
            car.move();
        }
    }
}
