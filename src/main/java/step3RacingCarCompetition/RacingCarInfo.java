package step3RacingCarCompetition;

import java.util.HashMap;
import java.util.List;
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


    public RacingCarInfo(List carData) {
        this.totalNumberOfCars = (int) carData.get(0);
        this.totalMovingCount = (int) carData.get(1);
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
