package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {

    List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCarList(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            racingCarList.add(new RacingCar());
        }
    }

    public List<RacingCar> list() {
        return this.racingCarList;
    }
}
