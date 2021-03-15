package step03;

import java.util.ArrayList;
import java.util.List;

public class RacingEventManager {

    private int tryCount = 0;
    private int carCount = 0;

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingEventManager(int carCount, int tryCount) {
        ValidateUtils.inputIsZero(carCount, tryCount);
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public List<RacingCar> getRacingResult() {
        return racingCars;
    }

    public void startRacing() {
        RacingCarFactory racingCarFactory = new RacingCarFactory();
        racingCarFactory.makeCars(carCount);
        racingCarFactory.racing(tryCount);
    }
}
