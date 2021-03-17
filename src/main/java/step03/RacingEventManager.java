package step03;

import java.util.List;

public class RacingEventManager {

    private int tryCount = 0;
    private int carCount = 0;
    RacingCarFactory racingCarFactory;

    public RacingEventManager(int carCount, int tryCount) {
        ValidateUtils.inputIsZero(carCount, tryCount);
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public void startRacing() {
        racingCarFactory = new RacingCarFactory();
        racingCarFactory.makeCars(carCount);
        racingCarFactory.racing(tryCount);
    }

    public List<RacingCar> getRacingResult() {
        return racingCarFactory.getRacingCars();
    }

}
