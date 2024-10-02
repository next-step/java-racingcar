package step3RacingCarCompetition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarInfo {

    private List<String> racingCarMovingData;

    public RacingCarInfo(int totalNumberOfCars) {

        this.racingCarMovingData = new ArrayList<>(Collections.nCopies(totalNumberOfCars, ""));
    }

    public void recordGoInRacingCarData(int numberOfCars, String moveString) {
        racingCarMovingData.set(numberOfCars, racingCarMovingData.get(numberOfCars) + moveString);
    }

    public String findRacingCarData(int numberOfCars) {
        return racingCarMovingData.get(numberOfCars);
    }
}
