package step03;

import java.util.ArrayList;
import java.util.List;

public class RacingEventManager {

    private int tryCount = 0;
    private int carCount = 0;

    private List<RacingCar> racingCars = new ArrayList<>();

    RacingEventManager(int carCount, int tryCount) {
        ValidateUtils.inputIsZero(carCount, tryCount);
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public List<RacingCar> getRacingResult() {
        return racingCars;
    }

    public void startRacing() {
        makeCars();
        for (int i = 0; i < tryCount; i++) {
            racing();
        }
    }

    private void racing() {
        for (RacingCar car : racingCars) {
            car.tryToMove(RandomUtils.randomRange());
        }
    }

    private void makeCars() {
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }
    }

}
