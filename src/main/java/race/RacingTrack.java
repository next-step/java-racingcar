package race;

import java.util.ArrayList;
import java.util.List;

public class RacingTrack {
    private final int maxCarCount;
    private final int maxAttemptCount;
    private final List<RacingCar> cars;

    public RacingTrack(int maxCarCount, int maxAttemptCount) {
        this.maxCarCount = maxCarCount;
        this.maxAttemptCount = maxAttemptCount;
        this.cars = new ArrayList<>();
    }

    public void startRace(int numOfCars, int numOfAttempts) {
        setupCars(numOfCars);

        ResultView.printRaceStartMessage();
        for (int i = 0; i < numOfAttempts; i++) {
            moveAndShowCars();
            ResultView.printRaceStatus(cars);
        }
    }

    public void setupCars(int numOfCars) {
        for (int i = 0; i < numOfCars; i++) {
            cars.add(RacingCarFactory.create(i, ResultView.createPositionPrinter()));
        }
    }

    private void moveAndShowCars() {
        for (RacingCar car : cars) {
            car.move();
        }
    }

    public boolean validateCarCount(int num) {
        return num >= 1 && num <= this.maxCarCount;
    }

    public boolean validateAttemptCount(int num) {
        return num >= 1 && num <= this.maxAttemptCount;
    }
}
