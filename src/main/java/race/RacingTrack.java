package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingTrack {
    private final Random random = new Random();

    private final TrackCondition trackCondition;
    private final List<RacingCar> cars;

    public RacingTrack(int maxCarCount, int maxAttemptCount) {
        this.trackCondition = new TrackCondition(maxCarCount, maxAttemptCount);
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

    private void setupCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new RacingCar(name));
        }
    }

    private void moveAndShowCars() {
        for (RacingCar car : cars) {
            car.moveWithSeed(random.nextInt());
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
        int maxPosition = 0;
        for (RacingCar car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        List<RacingCar> winners = new ArrayList<>();

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).isSamePosition(maxPosition)) winners.add(cars.get(i));
        }
        return winners;
    }
}
