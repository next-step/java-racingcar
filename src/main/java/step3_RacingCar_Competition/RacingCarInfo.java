package step3_RacingCar_Competition;

import java.util.HashMap;
import java.util.Map;

public class RacingCarInfo {
    private int numberOfCars;
    private int movingTryCount;

    public int NumberOfCars() {
        return numberOfCars;
    }

    public int MovingTryCount() {
        return movingTryCount;
    }

    private Map<Integer, String> racingCarMovingData;

    public RacingCarInfo(int numberOfCars, int movingTryCount) {
        this.numberOfCars = numberOfCars;
        this.movingTryCount = movingTryCount;
        this.racingCarMovingData = new HashMap<>();
    }

    public void recordGoInRacingCarData(int carNumber) {

    }
}
