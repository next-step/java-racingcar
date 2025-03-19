package race;

import java.util.ArrayList;
import java.util.Collections;
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

    public void startRace(String[] carNames, int numOfAttempts) {
        setupCars(carNames);

        ResultView.printRaceStartMessage();
        for (int i = 0; i < numOfAttempts; i++) {
            moveAndShowCars();
            ResultView.printRaceStatus(cars);
        }
    }

    public void startRace(List<RacingCar> cars, int numOfAttempts) {
        this.cars.addAll(cars);

        ResultView.printRaceStartMessage();
        for (int i = 0; i < numOfAttempts; i++) {
            moveAndShowCars();
            ResultView.printRaceStatus(cars);
        }
    }

    private void setupCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(RacingCarFactory.create(name, ResultView.createPositionPrinter()));
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

    public boolean validateCarNames(String[] names) {
        if (names.length < 1 || names.length > this.maxCarCount) {
            return false;
        }
        for (String name : names) {
            if (!RacingCar.validateName(name)) return false;
        }
        return true;
    }

    public List<RacingCar> getWinners() {
        cars.sort(Collections.reverseOrder());
        List<RacingCar> winners = new ArrayList<>();
        winners.add(cars.get(0));

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).compareTo(cars.get(0)) == 0) winners.add(cars.get(i));
        }
        return winners;
    }
}
