package race;

import java.util.List;

public class RacingTrack {
    private final TrackCondition trackCondition;
    private final CarList cars;

    public RacingTrack(int maxCarCount, int maxAttemptCount) {
        this.trackCondition = new TrackCondition(maxCarCount, maxAttemptCount);
        this.cars = new CarList();
    }

    public void startRace(String[] carNames, int numOfAttempts) {
        setupCars(carNames);

        ResultView.printRaceStartMessage();
        for (int i = 0; i < numOfAttempts; i++) {
            cars.moveWithRandom();
            ResultView.printRaceStatus(cars);
        }
    }

    private void setupCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new RacingCar(name));
        }
    }

    public boolean validateCarCount(int num) {
        return this.trackCondition.validateCarCount(num);
    }

    public boolean validateAttemptCount(int num) {
        return this.trackCondition.validateAttemptCount(num);
    }

    public boolean validateCarNames(String[] names) {
        if (!this.trackCondition.validateCarCount(names.length)) {
            return false;
        }
        for (String name : names) {
            if (!RacingCar.validateName(name)) return false;
        }
        return true;
    }

    public List<RacingCar> getWinners() {
        return this.cars.getWinners();
    }
}
