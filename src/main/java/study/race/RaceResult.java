package study.race;

import java.util.List;

public class RaceResult {

    int[] racingResult;
    List<Car> carList;

    public RaceResult(List<Car> carList) {
        racingResult = new int[carList.size()];
        this.carList = carList;
        this.updateRaceResult();
    }

    public int[] getResult() {
        return this.racingResult;
    }

    public void updateRaceResult() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            racingResult[i] = car.getCurrentLocation();
        }
    }
}
