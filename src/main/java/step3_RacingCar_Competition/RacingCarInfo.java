package step3_RacingCar_Competition;

import java.util.HashMap;
import java.util.Map;

public class RacingCarInfo {
    /**
     * TODO 과연 클래스 필드로 두는게 좋을까 startRacing 필드로 두는게 나을까
     */
    private final int totalNumberOfCars;
    private final int totalMovingCount;
    private Map<Integer, String> racingCarMovingData;

    public int totalNumberOfCars() {
        return totalNumberOfCars;
    }

    public int totalMovingCount() {
        return totalMovingCount;
    }


    public RacingCarInfo(int totalNumberOfCars, int totalMovingCount) {
        this.totalNumberOfCars = totalNumberOfCars;
        this.totalMovingCount = totalMovingCount;
        this.racingCarMovingData = new HashMap<>();
    }

    public void recordGoInRacingCarData(int carNumber) {
        String movingData = racingCarMovingData.getOrDefault(carNumber, "");
        racingCarMovingData.put(carNumber, movingData + "-");
    }

    public String findRacingCarData(int carNumber) {
        return racingCarMovingData.getOrDefault(carNumber, "");
    }
}
