package step3_RacingCar_Competition;

import java.util.HashMap;
import java.util.Map;

public class RacingCarInfo {
    private int numberOfCars;
    private int movingTryCount;
    private Map<Integer, String> racingCarMovingData;

    public RacingCarInfo(int numberOfCars, int movingTryCount) {
        this.numberOfCars = numberOfCars;
        this.movingTryCount = movingTryCount;
        this.racingCarMovingData = new HashMap<>();
    }
}
